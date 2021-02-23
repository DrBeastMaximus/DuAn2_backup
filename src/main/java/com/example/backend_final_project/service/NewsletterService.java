package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Email;

import java.util.List;

public interface NewsletterService {
    List<Email> getNewsletterEmailList();

    Email getNewsletterEmailById(int id);

    List<Email> getNewsletterEmailByEmail(String email);

    void addNewsletterEmail(Email newsletterEmail);

    void updateNewsletterEmail(Email newsletterEmail);

    void deleteNewsletterEmail(Email newsletterEmail);
}
