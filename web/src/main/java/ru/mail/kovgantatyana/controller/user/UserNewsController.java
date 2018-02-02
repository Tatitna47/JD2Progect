package ru.mail.kovgantatyana.controller.user;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.NewsService;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.service.model.CommentDTO;
import ru.mail.kovgantatyana.service.model.NewsDTO;
import ru.mail.kovgantatyana.service.model.UserDTO;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserNewsController {
    private static final Logger logger = Logger.getLogger(UserNewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "/user/news")
    public String newsAllNews(Model model) {
        List<NewsDTO> newsDTOList = newsService.getAll();
        for (NewsDTO newsDTO : newsDTOList) {
            logger.info(newsDTO.toString());
        }
        model.addAttribute("newsDTOList", newsDTOList);
        return "user/news/all";
    }

    @PostMapping(value = "/user/news/one")
    public String showOneNews(
            @RequestParam("newsId") int newsId,
            Model model) {
        NewsDTO newsDTO = newsService.getById(newsId);
        List<Comment> comments = newsDTO.getComments();
        model.addAttribute("comments", comments);
        model.addAttribute("newsDTO", newsDTO);
        return "user/news/one";
    }

    @PostMapping(value = "/user/news/comment/add")
    public String addComment(
            @RequestParam("comment") String comment,
            @RequestParam("date") String date,
            @RequestParam("newsId") int newsId,
            HttpSession session,
            Model model) {
        UserDTO userDTO = (UserDTO) session.getAttribute("userDTO");
        logger.info("user from session " + userDTO.toString());
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setDate(date);
        commentDTO.setMessage(comment);
        commentDTO.setUserId(userDTO.getId());
        commentDTO.setNewsId(newsId);
        newsService.saveComment(commentDTO);
        NewsDTO newsDTO = newsService.getById(newsId);
        List<Comment> comments = newsDTO.getComments();
        model.addAttribute("comments", comments);
        model.addAttribute("newsDTO", newsDTO);
        return "user/news/one";
    }
}
