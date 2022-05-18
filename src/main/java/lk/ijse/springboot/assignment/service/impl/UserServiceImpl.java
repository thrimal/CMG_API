package lk.ijse.springboot.assignment.service.impl;

import lk.ijse.springboot.assignment.dto.UserDTO;
import lk.ijse.springboot.assignment.entity.User;
import lk.ijse.springboot.assignment.repo.UserRepo;
import lk.ijse.springboot.assignment.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public boolean saveUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getId()+"")) {
            throw new RuntimeException("User Already Exists...");
        }
        userRepo.save(modelMapper.map(userDTO, User.class));
        return true;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> all = userRepo.findAll();
        return all;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) {
        if (userRepo.existsById(userDTO.getName())) {
            userRepo.save(modelMapper.map(userDTO,User.class));
            return true;
        }
        throw new RuntimeException("User Not Found...");
    }

    @Override
    public UserDTO findUser(String id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {
            return modelMapper.map(user.get(),UserDTO.class);
        }
        return null;

    }

    @Override
    public boolean deleteUser(String id) {
        if (! userRepo.existsById(id)) {
            throw new RuntimeException("User Not Found...");
        }
        userRepo.deleteById(id);
        return true;
    }

    @Override
    public UserDTO findByUserNameAndPassword(String userName, String password) {
        Optional<User> user = userRepo.findByUserNameAndPassword(userName, password);
//        System.out.println(user);
        if(user.isPresent()){
            UserDTO userDTO = modelMapper.map(user.get(), UserDTO.class);
            return userDTO;
        }
        return null;
    }
}
