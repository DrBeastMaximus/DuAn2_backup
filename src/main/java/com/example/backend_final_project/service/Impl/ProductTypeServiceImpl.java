package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.ProductTypeDAOImpl;
import com.example.backend_final_project.model.Product_type;
import com.example.backend_final_project.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductTypeServiceImpl implements ProductTypeService {
    @Autowired
    private ProductTypeDAOImpl productTypeDAOlmpl;

    @Override
    public List<Product_type> getProductTypeList() {

        return productTypeDAOlmpl.getProductTypeList();
    }

    @Override
    public Product_type getProductTypeById(int id) {

        return productTypeDAOlmpl.getProductTypeById(id);
    }

    @Override
    public List<Product_type> getProductTypeByName(String name) {

        return productTypeDAOlmpl.getProductTypeByName(name);
    }

    @Override
    public void addProductType(Product_type productType) {
    productTypeDAOlmpl.addProductType(productType);
    }

    @Override
    public void updateProductType(Product_type productType) {
    productTypeDAOlmpl.updateProductType(productType);
    }

    @Override
    public void deleteProductType(int productTypeID) {
    productTypeDAOlmpl.deleteProductType(productTypeID);
    }
}
