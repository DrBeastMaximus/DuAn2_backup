package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.BrandDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Brand;
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
public class BrandDAOImpl implements BrandDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private List<Brand> getListNonDeleted(){
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Brand", Brand.class).getResultList();
    }
    @Override
    public List<Brand> getBrandList() {
        return getListNonDeleted();
    }
    @Override
    public List<Brand> getListDeleted() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Brand where isdelete = false", Brand.class).getResultList();
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
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Brand where Name like :name and isdelete = false";
        Query query = session.createQuery(hql);
        query.setParameter("name", "%" + keyword + "%");
        List<Brand> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addBrand(Brand brand) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(brand);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateBrand(Brand brand) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(brand);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteBrand(int brandID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Brand brand = session.get(Brand.class, brandID);
            session.delete(brand);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
