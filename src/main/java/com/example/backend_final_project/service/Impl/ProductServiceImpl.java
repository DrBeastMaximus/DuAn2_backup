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
    public List<Product> getHotProductList() {
        return productDAOlmpl.getHotProductList();
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
    public List<Product> getProductListByBrandId(int brandID) {
        return productDAOlmpl.getProductListByBrandId(brandID);
    }

    @Override
    public List<Product> getProductListByGender(Boolean gender) {
        return productDAOlmpl.getProductListByGender(gender);
    }

    @Override
    public List<Product> getProductListByProdTypeId(int prodTypeID) {
        return productDAOlmpl.getProductListByProdTypeId(prodTypeID);
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
