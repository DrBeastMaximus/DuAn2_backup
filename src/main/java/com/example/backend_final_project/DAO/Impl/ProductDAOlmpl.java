package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductDAO;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Product_type;
import com.example.backend_final_project.model.User;
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
public class ProductDAOlmpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProductList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product where isdelete=0", Product.class).getResultList();
    }

    @Override
    public List<Product> getHotProductList() {
        //đang làm
        return null;
    }

    @Override
    public List<Product> getLatestProductList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product where isdelete=false order by created_date DESC ", Product.class).getResultList();
    }

    @Override
    public List<Product> getSalesProductList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product where isdelete=false and issale=1 ", Product.class).getResultList();
    }

    @Override
    public List<Product> getProductListByBrandId(int brandID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product where Brand like :brandID and isdelete=false";
        Query query = session.createQuery(hql);
        query.setParameter("brandID", brandID);
        List<Product> list = query.list();
        return list;
    }

    @Override
    public List<Product> getProductListByGender(Boolean gender) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product where gender = :gender and isdelete=false";
        Query query = session.createQuery(hql);
        query.setParameter("gender", gender);
        List<Product> list = query.list();
        return list;
    }

    @Override
    public List<Product> getProductListByProdTypeId(int prodTypeID) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product where Product_type = :prodTypeID and isdelete=false";
        Query query = session.createQuery(hql);
        query.setParameter("prodTypeID", prodTypeID);
        List<Product> list = query.list();
        return list;
    }

    @Override
    public List<Product> getProductListByKeyword(String keyword) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product where Code like :code or Name like :name and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("code", "%" + keyword + "%");
        query.setParameter("name", "%" + keyword + "%");
        List<Product> list = query.list();
        return list;
    }

    @Override
    public List<Product> getProductListInPriceRange(int minPrice, int maxPrice) {
        Session session = this.sessionFactory.openSession();
        String hql = "FROM Product where Price between :minPrice and :maxPrice and isdelete=false ";
        Query query = session.createQuery(hql);
        query.setParameter("minPrice", "%" + minPrice + "%");
        query.setParameter("maxPrice", "%" + maxPrice + "%");
        List<Product> list = query.list();
        return list;
    }

    @Override
    public Product getProductById(int id) {
        Session session = this.sessionFactory.openSession();
        String queryString = "from Product where isdelete=false and id = :id";
        return (Product) session.createQuery(queryString)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    @ExceptionHandler({SaveDataErrorException.class})
    public void addProduct(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(product);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({UpdateDataException.class})
    public void updateProduct(Product product) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(product);
            t.commit();
        } catch (Exception e) {
            t.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    @ExceptionHandler({DeleteDataException.class})
    public void deleteProduct(int productID) {
        Session session = this.sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        try {
            Product product = session.get(Product.class, productID);
            session.delete(product);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
