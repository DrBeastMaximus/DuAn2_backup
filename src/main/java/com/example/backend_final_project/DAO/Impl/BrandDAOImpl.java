package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.BrandDAO;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Brand;
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
public class BrandDAOImpl implements BrandDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private List<Brand> getList(){
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Brand", Brand.class).getResultList();
    }
    @Override
    public List<Brand> getBrandList() {
        return getList();
    }

    @Override
    public Brand getBrandById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "FROM Brand WHERE id = :id";
        return (Brand) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Brand> findBrandByKeyword(String keyword) {
        return null;
    }

    @Override
    public void addBrand(Brand brand) {

    }

    @Override
    public void updateBrand(Brand brand) {

    }

    @Override
    public void deleteBrand(int brandID) {

    }
}
