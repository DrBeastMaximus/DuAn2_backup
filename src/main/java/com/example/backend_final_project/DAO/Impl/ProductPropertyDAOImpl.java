package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductPropertyDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Product_Property;
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
public class ProductPropertyDAOImpl implements ProductPropertyDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product_Property> getProductPropertyList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product_Property", Product_Property.class).getResultList();
    }

    @Override
    public Product_Property getProductPropertyById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Product_Property where id = :id";
        return (Product_Property) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Product_Property> getProductPropertyByName(String name) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Property where Name like :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<Product_Property> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProductProperty(Product_Property productProperty) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(productProperty);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProductProperty(Product_Property productProperty) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(productProperty);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public boolean deleteProductProperty(int productPropertyID) {
        boolean ketqua = false;
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product_Property productProperty = session.get(Product_Property.class, productPropertyID);
            session.delete(productProperty);
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
