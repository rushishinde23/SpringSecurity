package com.SpringSecurityEx.service;

import com.SpringSecurityEx.dao.UsersRepository;
import com.SpringSecurityEx.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UsersRepository usersRepository;

    @InjectMocks
    private UserService userService;

    private Users user;

    @BeforeEach
    void setUp(){
        user=new Users(1,"rushi","r@123");
    }

    @Test
    void UserService_register_ReturnedUser(){
        when(usersRepository.save(any(Users.class))).thenReturn(user);

        Users registeredUser=userService.register(user);
        assertEquals("rushi",registeredUser.getUsername());
    }

}