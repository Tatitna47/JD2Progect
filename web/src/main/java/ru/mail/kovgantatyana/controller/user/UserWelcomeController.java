package ru.mail.kovgantatyana.controller.user;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mail.kovgantatyana.controller.WelcomeController;

@Controller
public class UserWelcomeController {
    private static final Logger logger = Logger.getLogger(WelcomeController.class);

    @GetMapping(value = "/user/welcome")
    public String welcome(Model model) {
        return "user/welcome";
    }

}
