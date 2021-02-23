package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.NewsletterDAOImpl;
import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.service.NewsletterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NewsletterServiceImpl implements NewsletterService {
    @Autowired
    private NewsletterDAOImpl newletterlDAOlmpl;

    @Override
    public List<Email> getNewsletterEmailList() {

        return newletterlDAOlmpl.getNewsletterEmailList();
    }

    @Override
    public Email getNewsletterEmailById(int id) {

        return newletterlDAOlmpl.getNewsletterEmailById(id);
    }

    @Override
    public List<Email> getNewsletterEmailByEmail(String email)
    {
        return newletterlDAOlmpl.getNewsletterEmailByEmail(email);
    }

    @Override
    public void addNewsletterEmail(Email newsletterEmail) {
    newletterlDAOlmpl.addNewsletterEmail(newsletterEmail);
    }

    @Override
    public void updateNewsletterEmail(Email newsletterEmail) {
    newletterlDAOlmpl.updateNewsletterEmail(newsletterEmail);
    }

    @Override
    public void deleteNewsletterEmail(int newsletterEmailID) {
    newletterlDAOlmpl.deleteNewsletterEmail(newsletterEmailID);
    }
}
