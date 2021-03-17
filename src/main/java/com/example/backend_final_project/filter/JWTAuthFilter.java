package com.example.backend_final_project.filter;

import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.AuthService;
import com.example.backend_final_project.service.Impl.AuthImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JWTAuthFilter extends BasicAuthenticationFilter {


    @Autowired
    private TokenFactory tokenFactory;
    @Autowired
    private UserServicelmpl userServicelmpl;
    @Autowired
    private final  AuthService authService;
    public JWTAuthFilter(AuthenticationManager authManager, AuthService authService) {
        super(authManager);
        this.authService = authService;
    }
       @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        try {

            // Lấy jwt từ request
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && tokenFactory.validateToken(jwt)) {

                // Lấy id user từ chuỗi jwt
                int userId = Integer.parseInt(tokenFactory.getUserIdFromJWT(jwt));
                UserDetails userDetails = authService.loadUserByID(userId);
                // Lấy thông tin người dùng từ id

//                if(userDetails != null) {
                    // Nếu người dùng hợp lệ, set thông tin cho Security Context
                    UsernamePasswordAuthenticationToken
                            authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
//                }
            }
        } catch (Exception ex) {
            System.out.println("Failed on set user authentication: "+ ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // Kiểm tra xem header Authorization có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}