package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> getProductList();

    List<Product> getMaleProductPage(int pos, int pageSize);

    List<Product> getFemaleProductPage(int pos, int pageSize);

    List<Product> getHotMaleProductPage(int pos, int pageSize);

    List<Product> getHotFemaleProductPage(int pos, int pageSize);


    List<Product> getMaleProductList();

    List<Product> getFemaleProductList();

    List<Product> getHotProductList();

    List<Product> getHotMaleProductList();

    List<Product> getHotMaleProductListFiltered(String pdID);

    List<Product> getHotFemaleProductListFiltered(String pdID);

    List<Product> getHotFemaleProductListFilteredInRange(String pdID, long min, long max);

    List<Product> getHotMaleProductListFilteredInRange(String pdID, long min, long max);

    List<Product> getHotFemaleProductListInRange(long min, long max);

    List<Product> getHotMaleProductListInRange(long min, long max);

    List<Product> getHotFemaleProductList();

    List<Product> getLatestProductList();

    List<Product> getSalesProductList();


    List<Product> getProductListByGender(Boolean gender);


    List<Product> getProductListByKeyword(String keyword);

    List<Product> getProductListInPriceRange(int minPrice, int maxPrice);

    Product getProductById(int id);

    void addProduct(Product product);

    void updateProduct(Product product);

    boolean deleteProduct(int productID);

}
