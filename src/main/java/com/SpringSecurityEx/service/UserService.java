package com.SpringSecurityEx.service;

import com.SpringSecurityEx.dao.UsersRepository;
import com.SpringSecurityEx.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UsersRepository usersRepository;

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
        //Users returnedUser= usersRepository.save(user);
        return user;
    }

}
