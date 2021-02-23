package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Email;

import java.util.List;

public interface NewsletterDAO {
    List<Email> getNewsletterEmailList();

    Email getNewsletterEmailById(int id);

    List<Email> getNewsletterEmailByEmail(String email);

    void addNewsletterEmail(Email newsletterEmail);

    void updateNewsletterEmail(Email newsletterEmail);

    void deleteNewsletterEmail(int newsletterEmailID);
}
