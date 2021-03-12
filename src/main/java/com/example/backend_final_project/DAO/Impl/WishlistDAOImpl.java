package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.WishlistDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Cart_Detail;
import com.example.backend_final_project.model.Product_type;
import com.example.backend_final_project.model.Wishlish;
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
public class WishlistDAOImpl implements WishlistDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Wishlish> getWishlishList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Wishlish", Wishlish.class).getResultList();
    }

    @Override
    public Wishlish getWishlishById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Wishlish where id = :id";
        return (Wishlish) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Wishlish> getWishlishByUserID(int userID) {
        Session session = this.sessionFactory.openSession();
        String hql = "from Wishlish where User = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", userID);
        List<Wishlish> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addWishlish(Wishlish wishlish) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(wishlish);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateWishlish(Wishlish wishlish) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(wishlish);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteWishlish(int wishlishID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Wishlish wishlish = session.get(Wishlish.class, wishlishID);
            session.delete(wishlish);
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
    public void deleteWishlishByProductID(int userID, int productID) {
        Session session = this.sessionFactory.openSession();
        session.createQuery("delete from Wishlish where Wishlish.User = :userID and Wishlish.product = :productID", Wishlish.class)
                .setParameter("userID",userID)
                .setParameter("productID",productID);
    }
}
