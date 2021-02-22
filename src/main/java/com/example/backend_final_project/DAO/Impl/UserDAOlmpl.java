package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.UserDAO;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

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
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
