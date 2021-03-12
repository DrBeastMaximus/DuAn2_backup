package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface ProductService {
    List<Product> getProductList();

    List<Product> getMaleProductPage(int pos, int pageSize);

    List<Product> getFemaleProductPage(int pos, int pageSize);

    List<Product> getHotMaleProductPage(int pos, int pageSize);

    List<Product> getHotFemaleProductPage(int pos, int pageSize);

    List<Product> getHotFemaleProductListFilteredInRange(int pdID, long min, long max);

    List<Product> getHotMaleProductListFilteredInRange(int pdID, long min, long max);

    List<Product> getHotFemaleProductListInRange(long min, long max);

    List<Product> getHotMaleProductListInRange(long min, long max);

    List<Product> getHotMaleProductListFiltered(int pdID);

    List<Product> getHotFemaleProductListFiltered(int pdID);

    List<Product> getMaleProductList();

    List<Product> getFemaleProductList();

    List<Product> getHotProductList();

    List<Product> getHotMaleProductList();

    List<Product> getHotFemaleProductList();

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

    void deleteProduct(int productID);
}
