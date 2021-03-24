package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.service.Impl.NewsletterServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterREST {
    @Autowired
    private NewsletterServiceImpl newsletterService;

    @PostMapping("/registerEmail")
    public ResponseEntity<?> registerEmail(@RequestBody JsonNode json){
        String email = json.get("email").asText();
        List<Email> nz = newsletterService.getNewsletterEmailByEmail(email);
        if(nz.size()==0){
            Email newsletter = new Email();
            newsletter.setEmail(email);
            newsletter.setCreated_date(new Date());
            newsletter.setIsdelete(false);
            newsletterService.addNewsletterEmail(newsletter);
            return ResponseEntity.ok("Đã đăng kí nhận tin thành công");
        } else{
            return ResponseEntity.badRequest().body("Mail đã đăng kí nhận tin!");
        }
    }
}
