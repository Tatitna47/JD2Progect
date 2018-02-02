package ru.mail.kovgantatyana.service;

import ru.mail.kovgantatyana.service.model.CommentDTO;
import ru.mail.kovgantatyana.repository.model.News;
import ru.mail.kovgantatyana.service.model.NewsDTO;

import java.util.List;

public interface NewsService {

    List<NewsDTO> getAll();

    void save(NewsDTO newsDTO);

    void delete(String newsname);

    NewsDTO getByName(String newsname);

    void saveComment(CommentDTO commentDTO);

    News getNewsById(int newsId);

    NewsDTO getById(int newsId);

    void deleteComment(String comment, String newsname);
}
