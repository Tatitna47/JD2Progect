package ru.mail.kovgantatyana.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.service.model.FeedBackDTO;

@Controller
public class UserFeedBackController {
    private static final Logger logger = Logger.getLogger(UserItemController.class);

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/feedback")
    public String getFormFeedback(Model model){
        return "user/feedback/form";
    }

    @PostMapping(value = "/user/feedback/add")
    public String addFeedback(
            @RequestParam("email") String email,
            @RequestParam("message") String message,
            Model model){
        FeedBackDTO feedBackDTO = new FeedBackDTO();
        feedBackDTO.setEmail(email);
        feedBackDTO.setMessage(message);
        userService.addFeedback(feedBackDTO);
        return "/user/welcome";
    }
}
