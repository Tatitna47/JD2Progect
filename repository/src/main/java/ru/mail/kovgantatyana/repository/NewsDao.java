package ru.mail.kovgantatyana.repository;

import ru.mail.kovgantatyana.repository.GenericDao;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.repository.model.News;

public interface NewsDao extends GenericDao<News, Integer> {

    void delete(String newsname);

    News getByName(String newsname);

    void deleteComment(String comment, String newsname);

    void deleteComment(int userId);

    void addComment(Comment comment);
}
