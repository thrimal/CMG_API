package lk.ijse.springboot.assignment.service;

import lk.ijse.springboot.assignment.dto.UserDTO;
import lk.ijse.springboot.assignment.entity.User;

import java.util.List;

public interface UserService {
    boolean saveUser(UserDTO userDTO);
    List<User> getAllUsers();
    boolean updateUser(UserDTO userDTO);
    UserDTO findUser(String id);
    boolean deleteUser(String id);
    UserDTO findByUserNameAndPassword(String userName, String password);
}
