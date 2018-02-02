package ru.mail.kovgantatyana.service;

import ru.mail.kovgantatyana.service.model.FeedBackDTO;
import ru.mail.kovgantatyana.repository.model.Role;
import ru.mail.kovgantatyana.repository.model.User;
import ru.mail.kovgantatyana.service.model.UserDTO;
import ru.mail.kovgantatyana.repository.model.UserStatusEnum;

import java.util.List;

public interface UserService {
    boolean isUserValid(String username, String password);

    UserDTO getByName(String userName);

    UserDTO getById(int userId);

    User getUserById(int userId);

    List<UserDTO> getAll();

    void changeStatus(int id, UserStatusEnum status);

    void changePassword(int userId, String password);

    void changeRole(int id, Role role);

    void saveUser(String username, String password);

    void update(UserDTO userDTO);

    void addFeedback(FeedBackDTO feedBackDTO);
    void delete(int userId);
}
