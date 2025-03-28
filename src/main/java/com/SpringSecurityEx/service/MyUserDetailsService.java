package com.SpringSecurityEx.service;

import com.SpringSecurityEx.dao.UsersRepository;
import com.SpringSecurityEx.entity.UserPrincipal;
import com.SpringSecurityEx.entity.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UsersRepository usersRepository;

    private static final Logger log= LoggerFactory.getLogger(MyUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user=usersRepository.findByUsername(username);
         System.out.println(user);
        //log.info("User:{}",user);
        if (user == null) {
            System.out.println("User Not Found");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(user);
    }
}
