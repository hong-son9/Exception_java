package com.example.demo.controllers;

import com.example.demo.dto.request.ApiResponse;
import com.example.demo.dto.request.UserCretionRequest;
import com.example.demo.dto.request.UserUpdateRequest;
import com.example.demo.entity.User;
import com.example.demo.services.UserService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCretionRequest request){
        ApiResponse<User> apiResponse = new ApiResponse<>();

        apiResponse.setResult((userService.createUser(request)));
       return apiResponse;
    }

    @GetMapping
    public ApiResponse<Object> getAllUsers(){
        var authencation = SecurityContextHolder.getContext().getAuthentication();
        log.info("Username: {}", authencation.getName());
        authencation.getAuthorities().forEach(grantedAuthority -> log.info(grantedAuthority.getAuthority()));


        return ApiResponse.builder()
                .result(userService.getAllUsers())
                .build();

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
