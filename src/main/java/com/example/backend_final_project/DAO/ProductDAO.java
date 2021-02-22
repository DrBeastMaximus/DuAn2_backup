package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Delivery;
import com.example.backend_final_project.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProductList();

    List<Product> getHotProductList();

    List<Product> getLatestProductList();

    List<Product> getSalesProductList();

    List<Product> getProductListByBrandId(int brandID);

    List<Product> getProductListByGender(Boolean gender);

    List<Product> getProductListByProdTypeId(int prodTypeID);

    List<Product> getProductListByKeyword(String keyword);

    List<Product> getProductListInPriceRange(int minPrice, int maxPrice);

    Product getProductById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Product product);

}
