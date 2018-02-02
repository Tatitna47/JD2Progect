package ru.mail.kovgantatyana.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.service.model.UserDTO;

import javax.servlet.http.HttpSession;

@Controller
public class UserProfileController {
    private static final Logger logger = Logger.getLogger(UserProfileController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/profile/show")
    public String showProfile(
            HttpSession session,
            Model model) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        model.addAttribute("userDTO", userDTO);
        return "user/profile/show";
    }

    @GetMapping(value = "/user/profile/change")
    public String showProfileForm(Model model) {
        return "user/profile/change/profile";
    }

    @PostMapping(value = "/user/profile/change")
    public String changeProfile(
            @RequestParam("name") String fullName,
            @RequestParam("login") String login,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("addinf") String addinf,
            HttpSession session,
            Model model) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        userDTO.setAdditionalInformation(addinf);
        userDTO.setPhone(phone);
        userDTO.setFullName(fullName);
        userDTO.setAddress(address);
        userDTO.setUsername(login);
        userService.update(userDTO);
        return "user/profile/show";
    }

    @GetMapping(value = "/user/change/password")
    public String showPasswordForm(Model model) {
        return "user/profile/change/password";
    }

    @PostMapping(value = "/user/change/password")
    public String changePassword(
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            HttpSession session,
            Model model) {
        if (!password.equals(repassword)){
            model.addAttribute("message", "password and password repeat are not the same");
            return "redirect:/user/change/password";
        }
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        userService.changePassword(userDTO.getId(), password);
        userDTO.setPassword(password);
        return "redirect:/user/profile/show";
    }
}
