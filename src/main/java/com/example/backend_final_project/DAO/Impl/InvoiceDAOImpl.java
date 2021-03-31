package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.InvoiceDAO;
import com.example.backend_final_project.exception.DeleteDataException;
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
        return session.createQuery("from Invoice where isdelete=false", Invoice.class).getResultList();
    }

    @Override
    public Invoice getInvoiceById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Invoice where isdelete=false and id = :id";
        return (Invoice) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Invoice> getInvoiceListByUserId(int userID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Invoice where User.Id = :id and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("id", userID);
        List<Invoice> list = query.list();
        return list;
    }

    @Override
    public List<Invoice> getInvoiceListByStatus(int status) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Invoice where Status = :id and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("id", status);
        List<Invoice> list = query.list();
        return list;
    }
    @Override
    public List<Object> getcountAll() {
        Session session = this.sessionFactory.openSession();
        String hql = "select Status as status, count(id) as quantity from Invoice group by Status";
        Query query = session.createQuery(hql);

        List<Object> list = query.list();
        return list;
    }


    @Override
    public List<Invoice> getInvoiceListByVoucherId(int voucherID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Invoice where Voucher.Code = :id and isdelete=false ";
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
    @ExceptionHandler({DeleteDataException.class})
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
