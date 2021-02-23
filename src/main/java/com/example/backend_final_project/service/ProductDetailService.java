package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Product_Detail;

import java.util.List;

public interface ProductDetailService {
    List<Product_Detail> getProductDetailList();

    Product_Detail getProductDetailById(int id);

    List<Product_Detail> getProductDetailListByProductId(int prodID);

    void addProductDetail(Product_Detail productDetail);

    void updateProductDetail(Product_Detail productDetail);

    void deleteProductDetail(int productDetailID);
}
