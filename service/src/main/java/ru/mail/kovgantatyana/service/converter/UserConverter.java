package ru.mail.kovgantatyana.service.converter;

import org.springframework.stereotype.Component;
import ru.mail.kovgantatyana.repository.model.User;
import ru.mail.kovgantatyana.service.model.UserDTO;
import ru.mail.kovgantatyana.repository.model.UserInfo;

@Component("userConverter")
public class UserConverter {

    public UserDTO convertToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(user.getPassword());
        userDTO.setRole(user.getRole());
        userDTO.setStatus(user.getStatus());
        userDTO.setEmail(user.getEmail());
        userDTO.setFullName(user.getUserInfo().getFullName());
        userDTO.setPhone(user.getUserInfo().getPhone());
        userDTO.setAddress(user.getUserInfo().getAddress());
        userDTO.setAdditionalInformation(user.getUserInfo().getAdditionalInformation());
        return userDTO;
    }

    public User convertToUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getUsername());
        UserInfo userInfo = new UserInfo();
        userInfo.setAdditionalInformation(userDTO.getAdditionalInformation());
        userInfo.setFullName(userDTO.getFullName());
        userInfo.setPhone(userDTO.getPhone());
        userInfo.setAddress(userDTO.getAddress());
        userInfo.setUser(user);
        user.setUserInfo(userInfo);
        return user;
    }
}
