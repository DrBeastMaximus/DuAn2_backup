package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.InvoiceDetailDAOImpl;
import com.example.backend_final_project.DAO.Impl.ProductDAOlmpl;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.backend_final_project.DAO.*;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAOlmpl productDAOlmpl;

    @Override
    public List<Product> getProductList() {
        return productDAOlmpl.getProductList();
    }

    @Override
    public List<Product> getMaleProductPage(int pos, int pageSize) {
        return  productDAOlmpl.getMaleProductPage(pos,pageSize);
    }

    @Override
    public List<Product> getFemaleProductPage(int pos, int pageSize) {
        return productDAOlmpl.getFemaleProductPage(pos,pageSize);
    }

    @Override
    public List<Product> getHotMaleProductPage(int pos, int pageSize) {
        return productDAOlmpl.getHotMaleProductPage(pos,pageSize);
    }

    @Override
    public List<Product> getHotFemaleProductPage(int pos, int pageSize) {
        return productDAOlmpl.getHotFemaleProductPage(pos,pageSize);
    }

    @Override
    public List<Product> getHotFemaleProductListFilteredInRange(String pdID, long min, long max) {
        return productDAOlmpl.getHotFemaleProductListFilteredInRange(pdID,min,max);
    }

    @Override
    public List<Product> getHotMaleProductListFilteredInRange(String pdID, long min, long max) {
        return productDAOlmpl.getHotMaleProductListFilteredInRange(pdID,min,max);
    }

    @Override
    public List<Product> getHotFemaleProductListInRange(long min, long max) {
        return productDAOlmpl.getHotFemaleProductListInRange(min,max);
    }

    @Override
    public List<Product> getHotMaleProductListInRange(long min, long max) {
        return productDAOlmpl.getHotFemaleProductListInRange(min,max);
    }

    @Override
    public List<Product> getHotMaleProductListFiltered(String pdID) {
        return productDAOlmpl.getHotMaleProductListFiltered(pdID);
    }

    @Override
    public List<Product> getHotFemaleProductListFiltered(String pdID) {
        return  productDAOlmpl.getHotFemaleProductListFiltered(pdID);
    }

    @Override
    public List<Product> getMaleProductList() {
        return productDAOlmpl.getMaleProductList();
    }

    @Override
    public List<Product> getFemaleProductList() {
        return productDAOlmpl.getFemaleProductList();
    }

    @Override
    public List<Product> getHotProductList() {
        return productDAOlmpl.getHotProductList();
    }

    @Override
    public List<Product> getHotMaleProductList() {
        return productDAOlmpl.getHotMaleProductList();
    }

    @Override
    public List<Product> getHotFemaleProductList() {
        return productDAOlmpl.getHotFemaleProductList();
    }

    @Override
    public List<Product> getLatestProductList() {
        return productDAOlmpl.getLatestProductList();
    }

    @Override
    public List<Product> getSalesProductList() {
        return productDAOlmpl.getSalesProductList();
    }


    @Override
    public List<Product> getProductListByGender(Boolean gender) {
        return productDAOlmpl.getProductListByGender(gender);
    }

    @Override
    public List<Product> getProductListByKeyword(String keyword) {
        return productDAOlmpl.getProductListByKeyword(keyword);
    }

    @Override
    public List<Product> getProductListInPriceRange(int minPrice, int maxPrice) {
        return productDAOlmpl.getProductListInPriceRange(minPrice, maxPrice);
    }

    @Override
    public Product getProductById(int id) {
        return productDAOlmpl.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
    productDAOlmpl.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
    productDAOlmpl.updateProduct(product);
    }

    @Override
    public void deleteProduct(int productID) {
    productDAOlmpl.deleteProduct(productID);
    }
}
