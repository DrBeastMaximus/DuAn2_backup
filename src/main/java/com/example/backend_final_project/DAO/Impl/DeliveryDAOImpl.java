package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.DeliveryDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Cart_Detail;
import com.example.backend_final_project.model.Delivery;
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
public class DeliveryDAOImpl implements DeliveryDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Delivery> getDeliveryList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Delivery", Delivery.class).getResultList();
    }

    @Override
    public Delivery getDeliveryById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Delivery WHERE id = :id";
        return (Delivery) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Delivery> getDeliveryListByInvoiceId(int invID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Delivery where Invoice like :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", invID);
        List<Delivery> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addDelivery(Delivery delivery) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(delivery);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateDelivery(Delivery delivery) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(delivery);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteDelivery(int deliveryID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Delivery delivery = session.get(Delivery.class, deliveryID);
            session.delete(delivery);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
