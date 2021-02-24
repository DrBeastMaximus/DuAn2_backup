package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.InvoiceDetailDAO;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Invoice_Detail;
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
public class InvoiceDetailDAOImpl implements InvoiceDetailDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Invoice_Detail> getInvoiceDetailList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from invoice_detail", Invoice_Detail.class).getResultList();
    }

    @Override
    public Invoice_Detail getInvoiceDetailById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from invoice_detail where id = :id";
        return (Invoice_Detail) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Invoice_Detail> getInvoiceDetailListByInvoiceId(int invoiceID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM invoice_detail where invoice_id like :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", invoiceID);
        List<Invoice_Detail> list = query.list();
        return list;
    }

    @Override
    public List<Invoice_Detail> getInvoiceDetailByProductId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM invoice_detail where product_id like :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Invoice_Detail> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addInvoiceDetail(Invoice_Detail invoiceD) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(invoiceD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateInvoiceDetail(Invoice_Detail invoiceD) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(invoiceD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void deleteInvoiceDetail(int invoiceDetailID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Invoice_Detail invoice_Detail = session.get(Invoice_Detail.class, invoiceDetailID);
            session.delete(invoice_Detail);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
