package com.SpringSecurityEx.controller;

import com.SpringSecurityEx.entity.Users;
import com.SpringSecurityEx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping ("/register")
    public Users register(@RequestBody Users user){
        Users returnedUser=this.userService.register(user);
        return returnedUser;
    }
}
