package ru.mail.kovgantatyana.service.converter;

import org.springframework.stereotype.Component;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.repository.model.News;
import ru.mail.kovgantatyana.service.model.NewsDTO;

import java.util.ArrayList;
import java.util.List;

@Component("newsconverter")
public class NewsConverter  {

    public NewsDTO convertToDTO(News news) {
        NewsDTO newsDTO = new NewsDTO();
        newsDTO.setId(news.getId());
        newsDTO.setNewsname(news.getNewsname());
        newsDTO.setAuthor(news.getAuthor());
        newsDTO.setDate(news.getDate());
        newsDTO.setContent(news.getContent());
        List<Comment> commentListDTO = new ArrayList<>();
        commentListDTO.addAll(news.getComments());
        newsDTO.setComments(commentListDTO);
        return newsDTO;
    }

    public News convertToNews(NewsDTO newsDTO) {
        News news = new News();
        news.setNewsname(newsDTO.getNewsname());
        news.setContent(newsDTO.getContent());
        news.setAuthor(newsDTO.getAuthor());
        news.setDate(newsDTO.getDate());
        return news;
    }
}
