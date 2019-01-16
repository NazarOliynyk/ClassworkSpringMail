package com.example.demo.controllers;



import com.example.demo.dao.ContactDAO;
import com.example.demo.models.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    ContactDAO contactDAO;
    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("message", "See your mail-box. Confirm the authorization pressing the button!");
        return "index";
    }
    
    @GetMapping("/confirm")
    public String confirm(Model model){


        model.addAttribute("message", "Contact is Authorized successfully!");
        return "index";
    }
}
