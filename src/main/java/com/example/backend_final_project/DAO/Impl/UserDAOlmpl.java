package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.UserDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
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
public class UserDAOlmpl implements UserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUserList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from User where isdelete=0 ", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM User WHERE id = :id and isdelete=0";
        return (User) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM User WHERE Email = :email and isdelete=false";
        return (User) session.createQuery(queryString)
                .setParameter("email", email)
                .uniqueResult();
    }

    @Override
    public User getUserByUsername(String username) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM User WHERE Username = :username and isdelete=false";
        return (User) session.createQuery(queryString)
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(user);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }
    @Override
    public List<User> findUserByKeyword(String keyword) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM User where Address like :addr or Fullname like :name or Phone like :phone or Username like :user or Email like :email and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("user", "%" + keyword + "%");
        query.setParameter("addr", "%" + keyword + "%");
        query.setParameter("name", "%" + keyword + "%");
        query.setParameter("phone", "%" + keyword + "%");
        query.setParameter("email", "%" + keyword + "%");
        List<User> list = query.list();
        return list;
    }
    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateUser(User user) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(user);
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
    public void deleteUser(int userID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            User user = session.get(User.class, userID);
            session.delete(user);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
