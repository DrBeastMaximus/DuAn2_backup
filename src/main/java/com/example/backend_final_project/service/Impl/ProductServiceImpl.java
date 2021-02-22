package com.example.backend_final_project.service.Impl;

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
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void editProduct(Product product) {

    }

    @Override
    public void deleteProduct(Product product) {

    }
}
