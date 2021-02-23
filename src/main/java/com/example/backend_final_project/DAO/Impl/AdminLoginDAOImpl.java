package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.AdminLoginDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Admin;
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
        return session.createQuery("from Admin", Admin.class).getResultList();
    }

    @Override
    public List<Admin> getAdminList() {
        return getList();
    }

    @Override
    public Admin getAdminById(int id) {
        return null;
    }

    @Override
    public List<Admin> findAdminByKeyword(String keyword) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Admin where username like :user or password like :pass or id like :id";
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
    public void deleteAdmin(Admin admin) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(admin);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }
}

