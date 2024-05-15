package com.chris.SpringBootRest.service;


import com.chris.SpringBootRest.Model.users;
import com.chris.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public users saveUser(users user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }


}
