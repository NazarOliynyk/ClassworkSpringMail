package com.example.demo.services;

import com.example.demo.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * Created by user on 17.01.19.
 */
public interface UserService extends UserDetailsService{

    void save(User user);

    List<User> findAll();

    User findOneById(Integer id);
}
