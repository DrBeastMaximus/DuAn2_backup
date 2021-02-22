package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Product_Detail;

import java.util.List;

public interface ProductDetailDAO {
    List<Product_Detail> getProductDetailList();

    Product_Detail getProductDetailById(int id);

    List<Product_Detail> getProductDetailListByProductId(int prodID);

    void addProductDetail(Product_Detail productDetail);

    void updateProductDetail(Product_Detail productDetail);

    void deleteProductDetail(Product_Detail productDetail);
}
