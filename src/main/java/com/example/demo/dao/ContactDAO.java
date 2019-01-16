package com.example.demo.dao;


import com.example.demo.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;
public interface ContactDAO extends JpaRepository<Contact, Integer> {
}
