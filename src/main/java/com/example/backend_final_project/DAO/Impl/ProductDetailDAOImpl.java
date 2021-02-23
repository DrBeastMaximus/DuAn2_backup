package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductDetailDAO;
import com.example.backend_final_project.model.Product_Detail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class ProductDetailDAOImpl implements ProductDetailDAO {
    @Override
    public List<Product_Detail> getProductDetailList() {
        return null;
    }

    @Override
    public Product_Detail getProductDetailById(int id) {
        return null;
    }

    @Override
    public List<Product_Detail> getProductDetailListByProductId(int prodID) {
        return null;
    }

    @Override
    public void addProductDetail(Product_Detail productDetail) {

    }

    @Override
    public void updateProductDetail(Product_Detail productDetail) {

    }

    @Override
    public void deleteProductDetail(Product_Detail productDetail) {

    }
}
