package ru.mail.kovgantatyana.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.service.model.ItemDTO;
import ru.mail.kovgantatyana.repository.model.Role;
import ru.mail.kovgantatyana.service.model.UserDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WelcomeController {
    private static final Logger logger = Logger.getLogger(WelcomeController.class);

    @Autowired
    private UserService userservice;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showWelcomePage(Model model) {
        return "welcome";
    }

    @GetMapping(value = "/logout")
    public String logout(
            HttpSession session,
            Model model) {
        session.invalidate();
        return "welcome";
    }

    @GetMapping(value = "/login")
    public String loginEnter(Model model) {
        model.addAttribute("user", new UserDTO());
        return "login";
    }

    @PostMapping(value = "/login")
    public String login(
           @Valid UserDTO userDTO,
            BindingResult result,
            Model model,
            HttpSession httpSession) {

        if (result.hasErrors()) {
            model.addAttribute("result", result);
            return "/login";

          /*  UserDTO userDTO = userservice.getByName(username);
            httpSession.setAttribute("userDTO", userDTO);
            Role role = userDTO.getRole();
            switch (role) {
                case USER:
                    List<ItemDTO> basket = new ArrayList<>();
                    httpSession.setAttribute("basket", basket);
                    return "user/welcome";
                case ADMIN:
                    return "admin/welcome";
                case SUPERADMIN:
                    return "superadmin/welcome";
            }*/
        }
        return "admin/welcome";
    }

    @GetMapping(value = "checkin")
    public String checkinEnter(Model model) {
        return "registration";
    }

    @PostMapping(value = "checkin")
    public String checkin(
            @RequestParam("username") String username,
            @RequestParam("mail") String mail,
            @RequestParam("phone") String phone,
            @RequestParam("address") String address,
            @RequestParam("addinf") String addinf,
            @RequestParam("password") String password,
            @RequestParam("repassword") String repassword,
            Model model) {
        logger.info("username " + username);
        logger.info("mail " + mail);
        logger.info("phone " + phone);
        logger.info("address " + address);
        logger.info("addinf " + addinf);
        logger.info("password " + password);
        logger.info("repassword " + repassword);
        return "welcome";
    }
}
