package com.SpringSecurityEx.service;

import com.SpringSecurityEx.dao.UsersRepository;
import com.SpringSecurityEx.entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MyUserDetailsServiceTest {

    @Mock
    private UsersRepository usersRepository;

   @InjectMocks
    private MyUserDetailsService myUserDetailsService;

   private Users user;

   @BeforeEach
    void setUp(){
       user=new Users(1,"rushi","r@123");
   }

   @Test
    void MyUserDetailsService_testUserByUserName_returnUserDetails(){
       when(usersRepository.findByUsername("rushi")).thenReturn(user);
       UserDetails userDetails=myUserDetailsService.loadUserByUsername("rushi");
       assertNotNull(userDetails);
       assertEquals("rushi",userDetails.getUsername());
   }

   @Test
    void MyUserDetailsService_testUserByUserName_returnNull(){
       when(usersRepository.findByUsername("tdit")).thenReturn(null);
       assertThrows(RuntimeException.class,()->
               myUserDetailsService.loadUserByUsername("unknown"));
   }

}