package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.NewsletterDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.model.Invoice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class NewsletterDAOImpl implements NewsletterDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Email> getNewsletterEmailList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Email where isdelete=false", Email.class).getResultList();
    }

    @Override
    public Email getNewsletterEmailById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Email where isdelete=false and id = :id";
        return (Email) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Email> getNewsletterEmailByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Email where Email = :email and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List<Email> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addNewsletterEmail(Email newsletterEmail) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(newsletterEmail);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateNewsletterEmail(Email newsletterEmail) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(newsletterEmail);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteNewsletterEmail(int newsletterEmailID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Email email = session.get(Email.class, newsletterEmailID);
            session.delete(email);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
