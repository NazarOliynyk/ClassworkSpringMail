package com.example.demo.controllers;



import com.example.demo.dao.ContactDAO;
import com.example.demo.models.Contact;
import com.example.demo.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import java.io.File;
import java.io.IOException;

@RestController
public class CustomRestController {


    @Autowired
    private ContactDAO contactDAO;
    @Autowired
    private EmailService emailService;
    @PostMapping("/upload")
    public
    @ResponseBody
        // allows to not return template
    String upload(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("image") MultipartFile image
    ) throws MessagingException {
        Contact contact = new Contact(name, email);
        contact.setAvatar(image.getOriginalFilename());
        String path = System.getProperty("user.home")
                + File.separator
                +"images"
                +File.separator
                +image.getOriginalFilename();
        try {
            image.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        contactDAO.save(contact);

        emailService.sendEmail(email, image);
        return "ok";
    }
}
