package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Product_Image;

import java.util.List;

public interface ProductImageDAO {
    List<Product_Image> getDeliveryList();

    Product_Image getProductImageById(int id);

    List<Product_Image> getProductImageByProdId(int prodID);

    void addProductImage(Product_Image productImage);

    void updateProductImage(Product_Image productImage);

    void deleteProductImage(Product_Image productImage);
}
