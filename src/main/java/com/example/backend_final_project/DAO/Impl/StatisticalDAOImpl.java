package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.StatisticalDAO;
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
public class StatisticalDAOImpl implements StatisticalDAO {
    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public Object getCountDHandDT() {
        Session session = this.sessionFactory.openSession();
        String hql = "select count(id) as count,sum(Total)as sum from Invoice where Status = 3";
        Query query = session.createQuery(hql);

        Object object = query.list();
        return object;
    }
}
