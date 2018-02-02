package ru.mail.kovgantatyana.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mail.kovgantatyana.service.NewsService;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.service.model.CommentDTO;
import ru.mail.kovgantatyana.repository.model.User;

@Component("commentConverter")
public class CommentConverter {

    @Autowired
    private UserService userService;

    @Autowired
    private NewsService newsService;

    public Comment convertToComment(CommentDTO commentDTO) {
        Comment comment = new Comment();
        comment.setDate(commentDTO.getDate());
        comment.setMessage(commentDTO.getMessage());
        User user = userService.getUserById(commentDTO.getUserId());
        comment.setUser(user);
        user.getComments().add(comment);
      //  News news = newsService.getNewsById(commentDTO.getNewsId());
     //   comment.setNews(news);
        return comment;
    }
}
