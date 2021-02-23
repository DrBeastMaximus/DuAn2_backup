package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Product_type;

import java.util.List;

public interface ProductTypeDAO {
    List<Product_type> getProductTypeList();

    Product_type getProductTypeById(int id);

    List<Product_type> getProductTypeByName(String name);

    void addProductType(Product_type productType);

    void updateProductType(Product_type productType);

    void deleteProductType(int productTypeID);
}
