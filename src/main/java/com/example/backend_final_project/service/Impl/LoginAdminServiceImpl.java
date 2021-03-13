package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.AdminLoginDAOImpl;
import com.example.backend_final_project.DAO.Impl.InvoiceDetailDAOImpl;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.service.LoginAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginAdminServiceImpl implements LoginAdminService {
    @Autowired
    private AdminLoginDAOImpl adminLoginDAOlmpl;

    @Override
    public List<Admin> getAdminList() {

        return adminLoginDAOlmpl.getAdminList();
    }

    @Override
    public Admin getAdminId(int id) {

        return adminLoginDAOlmpl.getAdminById(id);
    }
    @Override
    public Admin getAdminUsername(String username) {
        return adminLoginDAOlmpl.getAdminByUsername(username);
    }


    @Override
    public List<Admin> findAdminByKeyword(String keyword) {

        return adminLoginDAOlmpl.findAdminByKeyword(keyword);
    }

    @Override
    public void addAdmin(Admin admin) {
    adminLoginDAOlmpl.addAdmin(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
    adminLoginDAOlmpl.updateAdmin(admin);
    }

    @Override
    public void deleteAdmin(int adminID) {
    adminLoginDAOlmpl.deleteAdmin(adminID);
    }
}
