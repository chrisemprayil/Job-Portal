package com.chris.SpringBootRest.service;


import com.chris.SpringBootRest.Model.UserPrincipal;
import com.chris.SpringBootRest.Model.users;
import com.chris.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepo repo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      users user=  repo.findByUsername(username);

      if(user==null){

          System.out.println("User 404");
          throw new UsernameNotFoundException("user 404");
      }
        return new UserPrincipal(user);
    }
}