package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Product_Property;

import java.util.List;

public interface ProductPropertyDAO {
    List<Product_Property> getProductPropertyList();

    Product_Property getProductPropertyById(int id);

    List<Product_Property> getProductPropertyByName(String name);

    void addProductProperty(Product_Property productProperty);

    void updateProductProperty(Product_Property productProperty);

    void deleteProductProperty(Product_Property productProperty);
}
