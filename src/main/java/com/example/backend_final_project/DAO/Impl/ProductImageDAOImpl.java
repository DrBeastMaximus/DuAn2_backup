package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductImageDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Product_Image;
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
public class ProductImageDAOImpl implements ProductImageDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product_Image> getProductImagesList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product_Image where isdelete=false", Product_Image.class).getResultList();
    }

    @Override
    public Product_Image getProductImageById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Product_Image where isdelete=false and id = :id";
        return (Product_Image) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Product_Image> getProductImageByProdId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Image where Product.ID = :id and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Product_Image> list = query.list();
        return list;
    }

    @Override
    public List<Product_Image> getProductImagesByProdId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Image where Product.ID = :id and isdelete=false and Proiority=0";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Product_Image> list = query.list();
        return list;
    }
    @Override
    public List<Product_Image> getProductImagesIndexByProdId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Image where Product.ID = :id and isdelete=false and Proiority=1 ";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Product_Image> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProductImage(Product_Image productImage) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(productImage);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProductImage(Product_Image productImage) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(productImage);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteProductImage(int productImageID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product_Image productImage = session.get(Product_Image.class, productImageID);
            session.delete(productImage);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
