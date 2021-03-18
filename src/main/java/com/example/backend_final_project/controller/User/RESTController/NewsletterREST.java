package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.service.Impl.NewsletterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterREST {
    @Autowired
    private NewsletterServiceImpl newsletterService;

    @GetMapping("/registerEmail/{email}")
    public ResponseEntity<?> registerEmail(@PathVariable String email){
        List<Email> nz = newsletterService.getNewsletterEmailByEmail(email);
        if(nz.size()==0){
            Email newsletter = new Email();
            newsletter.setEmail(email);
            newsletter.setCreated_date(new Date());
            newsletter.setIsdelete(false);
            newsletterService.addNewsletterEmail(newsletter);
            return ResponseEntity.ok("Đã đăng kí nhận tin thành công");
        } else{
            return ResponseEntity.ok("Mail đã đăng kí nhận tin!");
        }
    }
}
