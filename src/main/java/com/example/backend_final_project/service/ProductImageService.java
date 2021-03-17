package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Product_Image;

import java.util.List;

public interface ProductImageService {
    List<Product_Image> getProductImagesList();

    Product_Image getProductImageById(int id);

    List<Product_Image> getProductImageByProdId(int prodID);

    List<Product_Image> getProductImagesByProdId(int prodID);

    List<Product_Image> getProductImagesIndexByProdId(int prodID);

    void addProductImage(Product_Image productImage);

    void updateProductImage(Product_Image productImage);

    void deleteProductImage(int productImageID);
}
