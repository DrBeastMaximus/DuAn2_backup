package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Admin;

import java.util.List;

public interface LoginAdminService {
    List<Admin> getAdminList();

    Admin getAdminId(int id);
    Admin getAdminUsername(String username);
    List<Admin> findAdminByKeyword(String keyword);

    void addAdmin(Admin admin);

    void updateAdmin(Admin admin);

    void deleteAdmin(int adminID);
}
