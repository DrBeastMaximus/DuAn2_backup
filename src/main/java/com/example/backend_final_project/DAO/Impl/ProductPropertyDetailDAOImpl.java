package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.ProductPropertyDetailDAO;
import com.example.backend_final_project.model.Product_Property_Detail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class ProductPropertyDetailDAOImpl implements ProductPropertyDetailDAO {
    @Override
    public List<Product_Property_Detail> getProductPropertyDetailList() {
        return null;
    }

    @Override
    public Product_Property_Detail getProductPropertyDetailById(int id) {
        return null;
    }

    @Override
    public List<Product_Property_Detail> getByProductPropertyDetailId(int id) {
        return null;
    }

    @Override
    public List<Product_Property_Detail> getByProductId(int prodID) {
        return null;
    }

    @Override
    public void addProductPropertyD(Product_Property_Detail productPropertyD) {

    }

    @Override
    public void updateProductPropertyD(Product_Property_Detail productPropertyD) {

    }

    @Override
    public void deleteProductPropertyD(int productPropertyDetailID) {

    }
}
