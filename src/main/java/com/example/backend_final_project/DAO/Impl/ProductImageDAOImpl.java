package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductImageDAO;
import com.example.backend_final_project.model.Product_Image;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class ProductImageDAOImpl implements ProductImageDAO {
    @Override
    public List<Product_Image> getProductImagesList() {
        return null;
    }

    @Override
    public Product_Image getProductImageById(int id) {
        return null;
    }

    @Override
    public List<Product_Image> getProductImageByProdId(int prodID) {
        return null;
    }

    @Override
    public void addProductImage(Product_Image productImage) {

    }

    @Override
    public void updateProductImage(Product_Image productImage) {

    }

    @Override
    public void deleteProductImage(int productImageID) {

    }
}
