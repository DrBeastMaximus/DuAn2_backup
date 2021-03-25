package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Product_Property_Detail;

import java.util.List;

public interface ProductPropertyDetailService {
    List<Product_Property_Detail> getProductPropertyDetailList();

    Product_Property_Detail getProductPropertyDetailById(int id);

    List<Product_Property_Detail> getByProductPropertyId(int id);

    List<Product_Property_Detail> getByProductId(int prodID);

    void addProductPropertyD(Product_Property_Detail productPropertyD);

    void updateProductPropertyD(Product_Property_Detail productPropertyD);

    void deleteProductPropertyD(int productPropertyDetailID);

    List<Product_Property_Detail> getByProductIdAndPropertyRoot(int prodID, int propertyRootID);
}
