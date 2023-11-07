package com.marcus.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcus.api.DTO.UserDTO;
import com.marcus.api.Model.Users.Users;
import com.marcus.api.Service.UserService;

@RestController()
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Users>> getAllUsers(){
        List usersList = userService.getAllUsers();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody UserDTO dto){
        Users newUser = userService.createUser(dto);
        System.out.println(newUser);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    

}
