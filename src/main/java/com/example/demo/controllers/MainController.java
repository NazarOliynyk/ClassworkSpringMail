package com.example.demo.controllers;



import com.example.demo.dao.ContactDAO;
import com.example.demo.models.Contact;
import com.example.demo.models.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class MainController {

    @Autowired
    ContactDAO contactDAO;
    @GetMapping("/")
    public String home(Model model){

        model.addAttribute("message", "3. Take a look into your mail-box. Confirm the authorization pressing the button!");
        return "index";
    }
    
    @GetMapping("/confirm")
    public String confirm(Model model){
        model.addAttribute("message", "4. Contact is Authorized successfully!");
        return "index";
    }

    // this method is for security purpose
    @PostMapping("/successURL")
    public String successURL(){
        return "redirect:/";
    }

    // this method is for security purpose
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @PostMapping("/saveUser")
    public String saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword())); // to encode the pass
        userService.save(user);
        return "redirect:/login";
    }
}
