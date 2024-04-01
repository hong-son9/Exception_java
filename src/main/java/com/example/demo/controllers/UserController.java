package com.example.demo.controllers;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.UserCretionRequest;
import com.example.demo.dto.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCretionRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult((userService.createUser(request)));
       return apiResponse;
    }

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id_user}")
    public User getUser(@PathVariable("id_user") String id_user){
        return userService.getUser(id_user);
    }

    @PutMapping("/{id_user}")
    public User updateUser(@PathVariable("id_user") String id_user,@RequestBody UserUpdateRequest request){
        return userService.updateUser(id_user, request);
    }

    @DeleteMapping("/{id_user}")
    public String deleteUser(@PathVariable("id_user")String id_user){
        userService.deleteUser(id_user);
        return "delete ok";
    }
}
