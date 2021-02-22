package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Brand;

import java.util.List;

public interface BrandDAO {
    List<Brand> getBrandList();

    Brand getBrandById(int id);

    List<Brand> findAdminByKeyword(String keyword);

    void addAdmin(Brand brand);

    void updateAdmin(Brand brand);

    void deleteAdmin(Brand brand);
}
