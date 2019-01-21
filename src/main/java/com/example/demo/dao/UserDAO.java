package com.example.demo.dao;

import com.example.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 17.01.19.
 */
public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);
}
