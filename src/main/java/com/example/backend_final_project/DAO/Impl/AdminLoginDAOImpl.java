package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.AdminLoginDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Admin;
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
public class AdminLoginDAOImpl implements AdminLoginDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private List<Admin> getList(){
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Admin where isdelete = false", Admin.class).getResultList();
    }

    @Override
    public List<Admin> getAdminList() {
        return getList();
    }

    @Override
    public Admin getAdminById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Admin WHERE id = :id and isdelete = false ";
        return (Admin) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }
    @Override
    public Admin getAdminByUsername(String username) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Admin WHERE Username = :username";
        return (Admin) session.createQuery(queryString)
                .setParameter("username", username)
                .uniqueResult();
    }

    @Override
    public List<Admin> findAdminByKeyword(String keyword) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Admin where Username like :user or Password like :pass or id like :id and isdelete = false";
        Query query = session.createQuery(hql);
        query.setParameter("user", "%" + keyword + "%");
        query.setParameter("pass", "%" + keyword + "%");
        query.setParameter("id", "%" + keyword + "%");
        List<Admin> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addAdmin(Admin admin) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(admin);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateAdmin(Admin admin) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(admin);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteAdmin(int adminID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Admin admin = session.get(Admin.class, adminID);
            session.delete(admin);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}

