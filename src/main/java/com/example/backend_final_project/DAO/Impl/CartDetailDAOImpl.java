package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.CartDetailDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Cart;
import com.example.backend_final_project.model.Cart_Detail;
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
public class CartDetailDAOImpl implements CartDetailDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Cart_Detail> getCartDetailList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from cart_detail", Cart_Detail.class).getResultList();
    }

    @Override
    public Cart_Detail getCartDetailById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Cart_Detail WHERE id = :id";
        return (Cart_Detail) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Cart_Detail> getCartDetailListByCardID(int cartID) {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("FROM Cart_Detail WHERE Cart.Id = :id", Cart_Detail.class).setParameter("id",cartID).getResultList();

    }

    @Override
    public void removeCartDetail(int cartID, int productID){
        Session session = this.sessionFactory.openSession();
        session.createQuery("delete from Cart_Detail where Cart_Detail.Cart = :cartID and Cart_Detail.product = :productID", Cart_Detail.class)
                .setParameter("cartID",cartID)
                .setParameter("productID",productID);
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addCartDetail(Cart_Detail cartD) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(cartD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateCartDetail(Cart_Detail cartD) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(cartD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteCartDetail(int cartDetailID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Cart_Detail cartD = session.get(Cart_Detail.class, cartDetailID);
            session.delete(cartD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
