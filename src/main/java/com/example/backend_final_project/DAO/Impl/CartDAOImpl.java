package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.CartDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Cart;
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
public class CartDAOImpl implements CartDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cart> getCartList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Cart", Cart.class).getResultList();
    }

    @Override
    public Cart getCartById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Cart WHERE id = :id";
        return (Cart) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }
    @Override
    public Cart getCartByUserId(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Cart WHERE User.Id = :id";
        return (Cart) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addCart(Cart cart) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(cart);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateCart(Cart cart) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(cart);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteCart(int cartID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Cart cart = session.get(Cart.class, cartID);
            session.delete(cart);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
