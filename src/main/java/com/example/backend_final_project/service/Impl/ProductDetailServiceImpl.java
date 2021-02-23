package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.ProductDetailDAOImpl;
import com.example.backend_final_project.model.Product_Detail;
import com.example.backend_final_project.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductDetailServiceImpl implements ProductDetailService {
    @Autowired
    private ProductDetailDAOImpl productDetailDAOlmpl;

    @Override
    public List<Product_Detail> getProductDetailList() {

        return productDetailDAOlmpl.getProductDetailList();
    }

    @Override
    public Product_Detail getProductDetailById(int id) {

        return productDetailDAOlmpl.getProductDetailById(id);
    }

    @Override
    public List<Product_Detail> getProductDetailListByProductId(int prodID) {

        return productDetailDAOlmpl.getProductDetailListByProductId(prodID);
    }

    @Override
    public void addProductDetail(Product_Detail productDetail) {
    productDetailDAOlmpl.addProductDetail(productDetail);
    }

    @Override
    public void updateProductDetail(Product_Detail productDetail) {
    productDetailDAOlmpl.updateProductDetail(productDetail);
    }

    @Override
    public void deleteProductDetail(Product_Detail productDetail) {
    productDetailDAOlmpl.deleteProductDetail(productDetail);
    }
}
