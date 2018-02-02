package ru.mail.kovgantatyana.controller.admin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminWelcomeController {
    private static final Logger logger = Logger.getLogger(AdminWelcomeController.class);

    @GetMapping(value = "admin/welcome")
    public String loginEnter(Model model) {
        return "admin/welcome";
    }

}
