package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.TrashcanDAO;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;
import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class TrashcanDAOImpl implements TrashcanDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUserdeleteList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from User where isdelete= true ", User.class).getResultList();
    }

    @Override
    public List<Product> getProductdeleteList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product where isdelete= true", Product.class).getResultList();
    }

    @Override
    public List<Voucher> getVoucherdeleteList() {

        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Voucher where Status = true", Voucher.class).getResultList();
    }

    @Override
    public List<Supplier> getSupplierdeleteList() {

        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Supplier where isdelete=true", Supplier.class).getResultList();
    }

    @Override
    public List<Admin> getadmindeleteList() {

        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Admin where isdelete = true", Admin.class).getResultList();
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void restoreUser(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            User user = session.get(User.class, id);
            user.setUpdate_date(new Date());
            user.setIsdelete(false);
            session.update(user);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void restoreProduct(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product product = session.get(Product.class, id);

            product.setIsdelete(false);
            session.update(product);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void restoreVoucher(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Voucher voucher = session.get(Voucher.class, id);
            voucher.setUpdated_date(new Date());
            voucher.setStatus(false);
            session.update(voucher);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void restoreSupplier(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Supplier supplier = session.get(Supplier.class, id);
            supplier.setUpdated_date(new Date());
            supplier.setIsdelete(false);
            session.update(supplier);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void restoreAdmin(int id) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Admin admin = session.get(Admin.class, id);
//            admin.setUpdated_date(new Date());
            admin.setIsdelete(false);
            session.update(admin);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
