package com.example.backend_final_project.filter;

import com.example.backend_final_project.Utils.GlobalConstant;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class AdminFilter extends GenericFilterBean {
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        String servletPath = request.getServletContext().getContextPath();
        if (servletPath.equals("/admin/login/auth/")) {
            chain.doFilter(request, response);
            return;
        }

        if(GlobalConstant.getUsername()!=null){
            chain.doFilter(request, response);
            return;
        }
    }
}
