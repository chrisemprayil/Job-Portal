package com.chris.SpringBootRest.repo;


import com.chris.SpringBootRest.Model.users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<users,Integer> {
    users findByUsername(String username);
}
