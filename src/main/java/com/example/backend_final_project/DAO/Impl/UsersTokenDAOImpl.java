package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.UsersTokenDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.model.UsersToken;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Repository
@Transactional
@EnableTransactionManagement
public class UsersTokenDAOImpl implements UsersTokenDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UsersToken getUserTokenByID(int idToken){
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM UsersToken WHERE id = :idToken";
        return (UsersToken) session.createQuery(queryString)
                .setParameter("idToken", idToken)
                .uniqueResult();
    }

    @Override
    public UsersToken getUserTokenByUID(int idUser){
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM UsersToken WHERE User.Id = :idUser";
        return (UsersToken) session.createQuery(queryString)
                .setParameter("idUser", idUser)
                .uniqueResult();
    }
    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addToken(UsersToken token) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(token);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }
    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateToken(UsersToken token) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(token);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteToken(int userID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            UsersToken token = session.get(UsersToken.class, userID);
            session.delete(token);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
