package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.SupplierDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Supplier;
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
public class SupplierDAOImpl implements SupplierDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Supplier> getSupplierList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Supplier where isdelete=false", Supplier.class).getResultList();
    }

    @Override
    public Supplier getSupplierById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Supplier where isdelete=false and id = :id";
        return (Supplier) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Supplier> getSupplierByName(String name) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Supplier where Name like :name and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<Supplier> list = query.list();
        return list;
    }

    @Override
    public List<Supplier> getSupplierByPhone(String phone) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Supplier where Phone like :phone and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("phone", phone);
        List<Supplier> list = query.list();
        return list;
    }

    @Override
    public List<Supplier> getSupplierByEmail(String email) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Supplier where Email like :email and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List<Supplier> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addSupplier(Supplier supplier) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(supplier);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateSupplier(Supplier supplier) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(supplier);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public boolean deleteSupplier(int SupplierID) {
        boolean ketqua = false;
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Supplier supplier = session.get(Supplier.class, SupplierID);
            session.delete(supplier);
            t.commit();
            ketqua = true;
        } catch (Exception e) {
//            t.rollback();
//            e.printStackTrace();
            ketqua = false;
        } finally {
            session.close();
        }
        return ketqua;
    }
}
