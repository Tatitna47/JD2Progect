package ru.mail.kovgantatyana.controller.superadmin;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SuperAdminWelcomeController {
    private static final Logger logger = Logger.getLogger(SuperAdminWelcomeController.class);

    @GetMapping(value = "superadmin/welcome")
    public String loginEnter(Model model) {
        return "superadmin/welcome";
    }
}
