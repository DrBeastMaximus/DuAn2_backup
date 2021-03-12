package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.service.Impl.NewsletterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterREST {
    @Autowired
    private NewsletterServiceImpl newsletterService;

    @GetMapping("/regiterEmail/{email}")
    public void registerEmail(@PathVariable String email){
        Email newsletter = new Email();
        newsletter.setEmail(email);
        if(newsletterService.getNewsletterEmailByEmail(email)==null){
            newsletterService.addNewsletterEmail(newsletter);
        }
    }
}
