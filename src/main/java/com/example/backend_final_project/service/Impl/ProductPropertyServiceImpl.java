package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.ProductPropertyDAOImpl;
import com.example.backend_final_project.model.Product_Property;
import com.example.backend_final_project.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductPropertyServiceImpl implements ProductPropertyService {
    @Autowired
    private ProductPropertyDAOImpl productPropertyDAOlmpl;

    @Override
    public List<Product_Property> getProductPropertyList() {

        return productPropertyDAOlmpl.getProductPropertyList();
    }

    @Override
    public Product_Property getProductPropertyById(int id) {

        return productPropertyDAOlmpl.getProductPropertyById(id);
    }

    @Override
    public List<Product_Property> getProductPropertyByName(String name) {

        return productPropertyDAOlmpl.getProductPropertyByName(name);
    }

    @Override
    public void addProductProperty(Product_Property productProperty) {
    productPropertyDAOlmpl.addProductProperty(productProperty);
    }

    @Override
    public void updateProductProperty(Product_Property productProperty) {
    productPropertyDAOlmpl.updateProductProperty(productProperty);
    }

    @Override
    public void deleteProductProperty(int productPropertyID) {
    productPropertyDAOlmpl.deleteProductProperty(productPropertyID);
    }
}
