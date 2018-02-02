package ru.mail.kovgantatyana.repository;

import ru.mail.kovgantatyana.repository.GenericDao;
import ru.mail.kovgantatyana.repository.model.Comment;
import ru.mail.kovgantatyana.repository.model.FeedBack;
import ru.mail.kovgantatyana.repository.model.Role;
import ru.mail.kovgantatyana.repository.model.User;
import ru.mail.kovgantatyana.repository.model.UserStatusEnum;

import java.util.List;

public interface UserDao extends GenericDao<User, Integer> {
    User getByName(String name);

    void delete(int userId);

    void changeStatus(int userId, UserStatusEnum status);

    void changeRole(int userId, Role role);

    void changePassword(int userId, String password);

    void addFeedback(FeedBack feedBack);

    List<Comment> getComments(int userId);
}
