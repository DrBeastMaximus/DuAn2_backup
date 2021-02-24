package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Brand;

import java.util.List;

public interface BrandDAO {
    List<Brand> getBrandList();

    List<Brand> getListDeleted();

    Brand getBrandById(int id);

    List<Brand> findBrandByKeyword(String keyword);

    void addBrand(Brand brand);

    void updateBrand(Brand brand);

    void deleteBrand(int brandID);
}
