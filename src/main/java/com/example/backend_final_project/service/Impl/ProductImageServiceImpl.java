package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.ProductImageDAOImpl;
import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductImageServiceImpl implements ProductImageService {
    @Autowired
    private ProductImageDAOImpl productImageDAOlmpl;

    @Override
    public List<Product_Image> getProductImagesList() {

        return productImageDAOlmpl.getProductImagesList();
    }

    @Override
    public Product_Image getProductImageById(int id) {

        return productImageDAOlmpl.getProductImageById(id);
    }

    @Override
    public List<Product_Image> getProductImageByProdId(int prodID) {

        return productImageDAOlmpl.getProductImageByProdId(prodID);
    }

    @Override
    public void addProductImage(Product_Image productImage) {
    productImageDAOlmpl.addProductImage(productImage);
    }

    @Override
    public void updateProductImage(Product_Image productImage) {
    productImageDAOlmpl.updateProductImage(productImage);
    }

    @Override
    public void deleteProductImage(int productImageID) {
    productImageDAOlmpl.deleteProductImage(productImageID);
    }
}
