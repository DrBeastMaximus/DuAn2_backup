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
    private ProductPropertyDetailDAOImpl productPropertyDetailDAOlmpl;

    @Override
    public List<Product_Property_Detail> getProductPropertyDetailList() {

        return productPropertyDetailDAOlmpl.getProductPropertyDetailList();
    }

    @Override
    public Product_Property_Detail getProductPropertyDetailById(int id) {

        return productPropertyDetailDAOlmpl.getProductPropertyDetailById(id);
    }

    @Override
    public List<Product_Property_Detail> getByProductPropertyId(int id) {

        return productPropertyDetailDAOlmpl.getByProductPropertyId(id);
    }

    @Override
    public List<Product_Property_Detail> getByProductId(int prodID) {

        return productPropertyDetailDAOlmpl.getByProductId(prodID);
    }

    @Override
    public void addProductPropertyD(Product_Property_Detail productPropertyD) {
        productPropertyDetailDAOlmpl.addProductPropertyD(productPropertyD);
    }

    @Override
    public void updateProductPropertyD(Product_Property_Detail productPropertyD) {
        productPropertyDetailDAOlmpl.updateProductPropertyD(productPropertyD);
    }

    @Override
    public void deleteProductPropertyD(int productPropertyDetailID) {
        productPropertyDetailDAOlmpl.deleteProductPropertyD(productPropertyDetailID);
    }
}
