package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class SessionService {
    @Autowired
    HttpSession session;
    /**
     * Đọc user từ session
     */
    public Admin getAdmin() {
        return (Admin) session.getAttribute("admin");
    }
    /**
     * Lưu user vào session
     */
    public void addAdmin(Admin admin) {

        session.setAttribute("admin", admin);
        session.setAttribute("username", admin.getUsername());
        session.setAttribute("role",admin.getRole());
    }
    /**
     * Xóa user khỏi session
     */
    public void removeAdmin() {

        session.removeAttribute("admin");
        session.removeAttribute("username");
        session.removeAttribute("role");
    }
    /**
     * Đọc security-url từ session
     */
    public String getSecurityUrl() {
        return (String) session.getAttribute("security-url");
    }
    /**
     * Lưu security-url vào session
     */
    public void addSecurityUrl(String securityUrl) {
        session.setAttribute("security-url", securityUrl);
    }
    /**
     * Xóa security-url khỏi session
     */
    public void removeSecurityUrl() {
        session.removeAttribute("security-url");
    }
    /**
     * Hủy bỏ session hiện tại
     */
    public void clear() {
        session.invalidate();
    }
}
