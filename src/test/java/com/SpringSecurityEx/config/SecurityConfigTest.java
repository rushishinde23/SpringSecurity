package com.SpringSecurityEx.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SecurityConfigTest {

    @Autowired
    AuthenticationProvider authenticationProvider;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

   /* @Test
    void SecurityConfig_testPasswordEncoder_ReturnedNotNull(){
        String rawPassword="password";
        String encodedPassword=passwordEncoder.encode(rawPassword);
        assertNotNull(encodedPassword);
        assertNotEquals(rawPassword,encodedPassword);
    }*/

    /*@Test
    void SecurityConfig_testAuthenticationProvider_ReturnedNotNull() {
        assertNotNull(authenticationProvider);
    }*/

}