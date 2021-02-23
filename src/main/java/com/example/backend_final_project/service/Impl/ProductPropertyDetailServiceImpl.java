package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.ProductPropertyDetailDAOImpl;
import com.example.backend_final_project.model.Product_Property_Detail;
import com.example.backend_final_project.service.ProductPropertyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductPropertyDetailServiceImpl implements ProductPropertyDetailService {
    @Autowired
    private ProductPropertyDetailDAOImpl productProperDetailtyDAOlmpl;

    @Override
    public List<Product_Property_Detail> getProductPropertyDetailList() {

        return productProperDetailtyDAOlmpl.getProductPropertyDetailList();
    }

    @Override
    public Product_Property_Detail getProductPropertyDetailById(int id) {

        return productProperDetailtyDAOlmpl.getProductPropertyDetailById(id);
    }

    @Override
    public List<Product_Property_Detail> getByProductPropertyDetailId(int id) {

        return productProperDetailtyDAOlmpl.getByProductPropertyDetailId(id);
    }

    @Override
    public List<Product_Property_Detail> getByProductId(int prodID) {

        return productProperDetailtyDAOlmpl.getByProductId(prodID);
    }

    @Override
    public void addProductPropertyD(Product_Property_Detail productPropertyD) {
    productProperDetailtyDAOlmpl.addProductPropertyD(productPropertyD);
    }

    @Override
    public void updateProductPropertyD(Product_Property_Detail productPropertyD) {
    productProperDetailtyDAOlmpl.updateProductPropertyD(productPropertyD);
    }

    @Override
    public void deleteProductPropertyD(int productPropertyDetailID) {
    productProperDetailtyDAOlmpl.deleteProductPropertyD(productPropertyDetailID);
    }
}
