package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.AdminLoginDAO;
import com.example.backend_final_project.model.Admin;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class AdminLoginDAOImpl implements AdminLoginDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Admin> getAdminList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Admin", Admin.class).getResultList();
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
    public void addAdmin(Admin admin) {

    }

    @Override
    public void updateAdmin(Admin admin) {

    }

    @Override
    public void deleteAdmin(Admin admin) {

    }
}

