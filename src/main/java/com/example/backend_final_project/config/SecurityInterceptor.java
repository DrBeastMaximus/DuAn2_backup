package com.example.backend_final_project.config;

import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    @Autowired
    SessionService session;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String uri = request.getRequestURI() + "?" + request.getQueryString();
        Admin admin = session.getAdmin();
        String error = "";

        if(admin == null) {

            error = "Vui lòng đăng nhập trước khi sử dụng chức năng này!";
        }
        else {
            if (admin.getRole() == 0 && uri.startsWith("/admin/statistical/")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }

            if (admin.getRole() == 0 && uri.startsWith("/admin/taikhoan/")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }
            if (admin.getRole() == 0 && uri.startsWith("/admin/user/")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }
            if (admin.getRole() == 0 && uri.startsWith("/admin/voucher/")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }

            if (admin.getRole() == 0 && uri.startsWith("/admin/trashcon/trashconadmin")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }
            if (admin.getRole() == 0 && uri.startsWith("/admin/trashcon/trashconuser")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }
            if (admin.getRole() == 0 && uri.startsWith("/admin/trashcon/trashconadmin")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }
            if (admin.getRole() == 0 && uri.startsWith("/admin/trashcon/trashconvouch")) {
                error = "Bạn không có quyền sử dụng chức năng này!";
            }

            /*-- Không lỗi -> cho phép truy xuất --*/
            if (error.length() == 0) {
                return true;
            }
            /*-- Có lỗi -> về đăng nhập --*/
//            session.addSecurityUrl(uri);
//        response.sendRedirect("/account/login?message=" + StrUtils.encodeUrl(error) );
        }
        response.sendRedirect("/admin/login/auth" );
        return false;
    }
}
