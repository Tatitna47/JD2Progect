package ru.mail.kovgantatyana.controller.admin;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.mail.kovgantatyana.service.NewsService;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.service.model.NewsDTO;

import java.util.List;

@Controller
public class AdminNewsController {
    private static final Logger logger = Logger.getLogger(AdminNewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping(value = "admin/news/all")
    public String showNews(Model model) {
        List<NewsDTO> newsDTOList = newsService.getAll();
        for (NewsDTO newsDTO : newsDTOList) {
            logger.info(newsDTO.toString());
        }
        model.addAttribute("newsDTOList", newsDTOList);
        return "admin/news/all";
    }

    @GetMapping(value = "admin/news/add")
    public String showNewsForm(Model model) {
        return "admin/news/add";
    }

    @PostMapping(value = "admin/news/add")
    public String addNews(
            @RequestParam("newsname") String newsname,
            @RequestParam("date") String date,
            @RequestParam("author") String author,
            @RequestParam("content") String content,
            Model model
    ) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setNewsname(newsname);
        newsDTO.setDate(date);
        newsDTO.setAuthor(author);
        newsDTO.setContent(content);
        logger.info(newsDTO.toString());
        newsService.save(newsDTO);
        List<NewsDTO> newsDTOList = newsService.getAll();
        model.addAttribute("newsDTOList", newsDTOList);
        return "admin/news/all";
    }

    @GetMapping(value = "admin/news/update")
    public String updateNews(Model model) {
        return "redirect:/admin/news/all";
    }

    @PostMapping(value = "admin/news/delete")
    public String deleteNews(
            @RequestParam("newsname") String newsname,
            Model model) {
        newsService.delete(newsname);
        return "redirect:/admin/news/all";
    }

    @PostMapping(value = "admin/news/one")
    public String showWholeNews(
            @RequestParam("newsname") String newsname,
            Model model) {
        NewsDTO newsDTO = newsService.getByName(newsname);
        List<Comment> comments = newsDTO.getComments();
        model.addAttribute("comments", comments);
        model.addAttribute("newsDTO", newsDTO);
        return "admin/news/one";
    }

    @PostMapping(value = "admin/news/one/comment/delete")
    public String deleteComment(
            @RequestParam("comment") String comment,
            @RequestParam("newsname") String newsname,
            Model model) {
        newsService.deleteComment(comment, newsname);
        NewsDTO newsDTO = newsService.getByName(newsname);
        List<Comment> comments = newsDTO.getComments();
        model.addAttribute("comments", comments);
        model.addAttribute("newsDTO", newsDTO);
        return "admin/news/one";
    }
}
