package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.InvoiceDAO;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Cart_Detail;
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
public class InvoiceDAOImpl implements InvoiceDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Invoice> getInvoiceList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from invoice where isdelete=0", Invoice.class).getResultList();
    }

    @Override
    public Invoice getInvoiceById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from invoice where isdelete=0 and id = :id";
        return (Invoice) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Invoice> getInvoiceListByUserId(int userID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM invoice where user_id like :id and isdelete=0";
        Query query = session.createQuery(hql);
        query.setParameter("id", userID);
        List<Invoice> list = query.list();
        return list;
    }

    @Override
    public List<Invoice> getInvoiceListByVoucherId(int voucherID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM invoice where voucher_id like :id and isdelete=0";
        Query query = session.createQuery(hql);
        query.setParameter("id", voucherID);
        List<Invoice> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addInvoice(Invoice invoice) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(invoice);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateInvoice(Invoice invoice) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(invoice);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void deleteInvoice(int invoiceID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Invoice invoice = session.get(Invoice.class, invoiceID);
            session.delete(invoice);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
