package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductTypeDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Product_Property;
import com.example.backend_final_project.model.Product_type;
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
public class ProductTypeDAOImpl implements ProductTypeDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product_type> getProductTypeList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product_type where isdelete=0", Product_type.class).getResultList();
    }

    @Override
    public Product_type getProductTypeById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Product_type where isdelete=false and id = :id";
        return (Product_type) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Product_type> getProductTypeByName(String name) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_type where Name like :name and isdelete=0";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<Product_type> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProductType(Product_type productType) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(productType);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProductType(Product_type productType) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(productType);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteProductType(int productTypeID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product_type productType = session.get(Product_type.class, productTypeID);
            session.delete(productType);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
