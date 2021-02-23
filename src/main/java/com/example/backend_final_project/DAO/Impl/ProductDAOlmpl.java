package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductDAO;
import com.example.backend_final_project.model.Product;
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
public class ProductDAOlmpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Product> getProductList() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public List<Product> getHotProductList() {
        return null;
    }

    @Override
    public List<Product> getLatestProductList() {
        return null;
    }

    @Override
    public List<Product> getSalesProductList() {
        return null;
    }

    @Override
    public List<Product> getProductListByBrandId(int brandID) {
        return null;
    }

    @Override
    public List<Product> getProductListByGender(Boolean gender) {
        return null;
    }

    @Override
    public List<Product> getProductListByProdTypeId(int prodTypeID) {
        return null;
    }

    @Override
    public List<Product> getProductListByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<Product> getProductListInPriceRange(int minPrice, int maxPrice) {
        return null;
    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProduct(int productID) {

    }

}
