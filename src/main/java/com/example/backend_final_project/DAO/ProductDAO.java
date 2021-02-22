package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);


}
