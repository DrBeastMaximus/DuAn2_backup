package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductPropertyDAO;
import com.example.backend_final_project.model.Product_Property;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class ProductPropertyDAOImpl implements ProductPropertyDAO {
    @Override
    public List<Product_Property> getProductPropertyList() {
        return null;
    }

    @Override
    public Product_Property getProductPropertyById(int id) {
        return null;
    }

    @Override
    public List<Product_Property> getProductPropertyByName(String name) {
        return null;
    }

    @Override
    public void addProductProperty(Product_Property productProperty) {

    }

    @Override
    public void updateProductProperty(Product_Property productProperty) {

    }

    @Override
    public void deleteProductProperty(Product_Property productProperty) {

    }
}
