package ru.mail.kovgantatyana.controller.superadmin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.repository.model.Role;
import ru.mail.kovgantatyana.service.model.UserDTO;
import ru.mail.kovgantatyana.repository.model.UserStatusEnum;

import java.util.List;

@Controller
public class SuperAdminUserController {
    private static final Logger logger = Logger.getLogger(SuperAdminUserController.class);

    @Autowired
    private UserService userservice;

    @GetMapping(value = "superadmin/user/all")
    public String showUsers(Model model) {
        List<UserDTO> userDTOList = userservice.getAll();
        model.addAttribute("userDTOList", userDTOList);
        return "superadmin/user/all";
    }

    @GetMapping(value = "superadmin/user/change/password")
    public String showFormPassword(
            @RequestParam("userId") int userId,
            @RequestParam("userName") String userName,
            Model model) {
        model.addAttribute("userId", userId);
        model.addAttribute("userName", userName);
        return "superadmin/user/changepassword";
    }

    @PostMapping(value = "superadmin/user/change/password")
    public String changePassword(
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            @RequestParam("userId") int userId,
            Model model) {
        userservice.changePassword(userId, password);
        return "redirect:/superadmin/user/all";
    }

    @PostMapping(value = "superadmin/user/change/role")
    public String changeRole(
            @RequestParam("userRole") Role role,
            @RequestParam("userId") int userId,
            Model model) {
        userservice.changeRole(userId, role);
        return "redirect:/superadmin/user/all";
    }

    @PostMapping(value = "superadmin/user/change/status")
    public String changeStatus(
            @RequestParam("userId") int userId,
            @RequestParam("userStatus") UserStatusEnum status,
            Model model) {
        userservice.changeStatus(userId, status);
        return "redirect:/superadmin/user/all";
    }

    @PostMapping(value = "superadmin/user/delete")
    public String deleteUser(
            @RequestParam("userId") int userId,
            Model model) {
        userservice.delete(userId);
        return "redirect:/superadmin/user/all";
    }

}
