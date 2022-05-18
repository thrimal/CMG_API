package lk.ijse.springboot.assignment.controller;

import lk.ijse.springboot.assignment.dto.UserDTO;
import lk.ijse.springboot.assignment.entity.User;
import lk.ijse.springboot.assignment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveUser(@RequestBody UserDTO userDTO){

        try{
            userService.saveUser(userDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getAllUsers(){
        try{
            return userService.getAllUsers();
        }catch (Exception e){
            throw new RuntimeException();
        }

    }

    @GetMapping(path = "/{userName}/{password}",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody UserDTO getUserByUserNameAndPassword(@PathVariable String userName,@PathVariable String password){
        try{
            UserDTO user = userService.findByUserNameAndPassword(userName, password);
            return user;
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

//    @GetMapping(path = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody UserDTO getUser(@RequestBody UserDTO userDTO){
//        UserDTO user = userService.findUser(userDTO.getName());
//        return user;
//    }

}
