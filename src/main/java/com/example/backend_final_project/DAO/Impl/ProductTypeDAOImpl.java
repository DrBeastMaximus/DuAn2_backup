package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductTypeDAO;
import com.example.backend_final_project.model.Product_type;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class ProductTypeDAOImpl implements ProductTypeDAO {
    @Override
    public List<Product_type> getProductTypeList() {
        return null;
    }

    @Override
    public Product_type getProductTypeById(int id) {
        return null;
    }

    @Override
    public List<Product_type> getProductTypeByName(String name) {
        return null;
    }

    @Override
    public void addProductType(Product_type productType) {

    }

    @Override
    public void updateProductType(Product_type productType) {

    }

    @Override
    public void deleteProductType(Product_type productType) {

    }
}
