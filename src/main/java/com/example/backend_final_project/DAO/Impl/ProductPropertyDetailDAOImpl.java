package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductPropertyDetailDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Invoice;
import com.example.backend_final_project.model.Product_Property_Detail;
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
public class ProductPropertyDetailDAOImpl implements ProductPropertyDetailDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product_Property_Detail> getProductPropertyDetailList() {
        Session session = this.sessionFactory.openSession();
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaa");
        return session.createQuery("from Product_Property_Detail", Product_Property_Detail.class).getResultList();
    }

    @Override
    public Product_Property_Detail getProductPropertyDetailById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Product_Property_Detail where id = :id";
        return (Product_Property_Detail) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public List<Product_Property_Detail> getByProductPropertyId(int id) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Property_Detail where Product_Property.ID like :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Product_Property_Detail> list = query.list();
        return list;
    }

    @Override
    public List<Product_Property_Detail> getByProductId(int prodID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product_Property_Detail where Product.ID like :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", prodID);
        List<Product_Property_Detail> list = query.list();
        return list;
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProductPropertyD(Product_Property_Detail productPropertyD) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(productPropertyD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProductPropertyD(Product_Property_Detail productPropertyD) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(productPropertyD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteProductPropertyD(int productPropertyDetailID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product_Property_Detail productPropertyD = session.get(Product_Property_Detail.class, productPropertyDetailID);
            session.delete(productPropertyD);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
