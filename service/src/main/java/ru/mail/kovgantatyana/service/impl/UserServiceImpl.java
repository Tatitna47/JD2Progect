package ru.mail.kovgantatyana.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.kovgantatyana.repository.UserDao;
import ru.mail.kovgantatyana.service.UserService;
import ru.mail.kovgantatyana.service.converter.FeedbackConverter;
import ru.mail.kovgantatyana.service.converter.UserConverter;
import ru.mail.kovgantatyana.repository.model.FeedBack;
import ru.mail.kovgantatyana.service.model.FeedBackDTO;
import ru.mail.kovgantatyana.repository.model.Role;
import ru.mail.kovgantatyana.repository.model.User;
import ru.mail.kovgantatyana.service.model.UserDTO;
import ru.mail.kovgantatyana.repository.model.UserStatusEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("userservice")
public class UserServiceImpl implements UserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private FeedbackConverter feedbackConverter;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public boolean isUserValid(String username, String password) {
        User user = userDao.getByName(username);
        return user != null && Objects.equals(user.getPassword(), password);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public UserDTO getByName(String username) {
        User user = userDao.getByName(username);
        UserDTO userDTO = userConverter.convertToDTO(user);
        logger.info("User from Service getByName" + userDTO.toString());
        return userDTO;
    }

    @Override
    public UserDTO getById(int userId) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public User getUserById(int userId) {
        User user = userDao.findById(userId);
        user.setComments(userDao.getComments(userId));
        return user;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<UserDTO> getAll() {
        List<User> userList = userDao.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userList) {
            userDTOList.add(userConverter.convertToDTO(user));
        }
        return userDTOList;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void changeStatus(int id, UserStatusEnum status){
        userDao.changeStatus(id, status);
    }

    @Override
    @Transactional
    public void changePassword(int userId, String password){
        userDao.changePassword(userId, password);
    }

    @Override
    @Transactional
    public void changeRole(int id, Role role){
        userDao.changeRole(id, role);
    }

    @Override
    public void saveUser(String username, String password) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(UserDTO userDTO) {
        User user = userConverter.convertToUser(userDTO);
        userDao.saveOrUpdate(user);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addFeedback(FeedBackDTO feedBackDTO) {
        FeedBack feedBack = feedbackConverter.convertToFeedBack(feedBackDTO);
        userDao.addFeedback(feedBack);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(int userId) {
        userDao.delete(userId);
    }
}
