package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.BrandDAO;
import com.example.backend_final_project.model.Brand;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class BrandDAOImpl implements BrandDAO {

    @Override
    public List<Brand> getBrandList() {
        return null;
    }

    @Override
    public Brand getBrandById(int id) {
        return null;
    }

    @Override
    public List<Brand> findBrandByKeyword(String keyword) {
        return null;
    }

    @Override
    public void addBrand(Brand brand) {

    }

    @Override
    public void updateBrand(Brand brand) {

    }

    @Override
    public void deleteBrand(Brand brand) {

    }
}
