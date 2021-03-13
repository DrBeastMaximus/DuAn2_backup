package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Admin;

import java.util.List;

public interface AdminLoginDAO {
    List<Admin> getAdminList();

    Admin getAdminById(int id);
    Admin getAdminByUsername(String Username);
    List<Admin> findAdminByKeyword(String keyword);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(int adminID);
}

