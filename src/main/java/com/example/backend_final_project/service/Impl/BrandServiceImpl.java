package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.BrandDAOImpl;
import com.example.backend_final_project.model.Brand;
import com.example.backend_final_project.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDAOImpl brandDAOlmpl;


    @Override
    public List<Brand> getBrandList() {
        return brandDAOlmpl.getBrandList();
    }

    @Override
    public Brand getBrandById(int id) {
        return brandDAOlmpl.getBrandById(id);
    }

    @Override
    public List<Brand> findBrandByKeyword(String keyword) {
        return brandDAOlmpl.findBrandByKeyword(keyword);
    }

    @Override
    public void addBrand(Brand brand) {
        brandDAOlmpl.addBrand(brand);
    }

    @Override
    public void updateBrand(Brand brand) {
        brandDAOlmpl.updateBrand(brand);
    }

    @Override
    public void deleteBrand(Brand brand) {
        brandDAOlmpl.deleteBrand(brand);
    }
}
