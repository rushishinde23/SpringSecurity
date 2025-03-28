package com.SpringSecurityEx.controller;

import com.SpringSecurityEx.entity.Users;
import com.SpringSecurityEx.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {
   private MockMvc mockMvc;

   @Mock
    private UserService userService;

   @InjectMocks
    private UserController userController;

   private Users user;

   @BeforeEach
    void setUp(){
       user=new Users(1,"rushi","1234");
       mockMvc= MockMvcBuilders.standaloneSetup(userController).build();
   }

   @Test
    void UserController_register_ReturnedUser() throws Exception {
       when(userService.register(any(Users.class))).thenReturn(user);

       mockMvc.perform(post("/register")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content("{\"id\":1,\"username\":\"rushi\",\"password\":\"1234\"}"))
               .andExpect(status().isOk());


   }
}