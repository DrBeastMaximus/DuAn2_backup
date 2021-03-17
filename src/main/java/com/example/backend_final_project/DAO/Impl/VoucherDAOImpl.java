package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.VoucherDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Voucher;
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
public class VoucherDAOImpl implements VoucherDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Voucher> getVoucherList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Voucher", Voucher.class).getResultList();
    }

    @Override
    public Voucher getVoucherById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Voucher where id = :id";
        return (Voucher) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Voucher> getVoucherByCode(String code) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Voucher where Code like :code";
        Query query = session.createQuery(hql);
        query.setParameter("code", code);
        List<Voucher> list = query.list();
        return list;
    }

    @Override
    public List<Voucher> getVoucherByProductTypeID(int prodTypeID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Voucher where Product_type like :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodTypeID);
        List<Voucher> list = query.list();
        return list;
    }

    @Override
    public List<Voucher> getVoucherByStatus(int status) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Voucher where Status like :status";
        Query query = session.createQuery(hql);
        query.setParameter("status", status);
        List<Voucher> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addVoucher(Voucher voucher) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(voucher);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateVoucher(Voucher voucher) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(voucher);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteVoucher(int voucherID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Voucher voucher = session.get(Voucher.class, voucherID);
            session.delete(voucher);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
