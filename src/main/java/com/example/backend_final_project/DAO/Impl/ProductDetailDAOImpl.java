package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductDetailDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Product_Detail;
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
public class ProductDetailDAOImpl implements ProductDetailDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product_Detail> getProductDetailList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product_Detail ", Product_Detail.class).getResultList();
    }

    @Override
    public Product_Detail getProductDetailById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Product_Detail where id = :id";
        return (Product_Detail) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Product_Detail> getProductDetailListByProductId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Detail where Product.ID = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Product_Detail> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProductDetail(Product_Detail productDetail) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(productDetail);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProductDetail(Product_Detail productDetail) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(productDetail);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteProductDetail(int productDetailID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product_Detail productDetail = session.get(Product_Detail.class, productDetailID);
            session.delete(productDetail);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
