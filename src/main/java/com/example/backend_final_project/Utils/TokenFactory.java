package com.example.backend_final_project.Utils;

import com.example.backend_final_project.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component

public class TokenFactory {
    // Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
    private final static String JWT_SECRET = "PROJECT2FPOLY2K21";

    //Thời gian có hiệu lực của token
    private static final long JWT_EXPIRATION = 604800000L;

    // Tạo ra token từ thông tin user
    public static String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);
        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Integer.toString(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // Tạo ra token từ thông tin user
    public static String generateToken2(Authentication auth, User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + JWT_EXPIRATION);

        // Tạo chuỗi json web token từ id của user.
        return Jwts.builder()
                .setSubject(Integer.toString(user.getId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, JWT_SECRET)
                .compact();
    }

    // Lấy userid từ token
    public static String getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
    //Xác thực giá trị của Token
    public static boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("Token không hợp lệ");
        } catch (ExpiredJwtException ex) {
            System.out.println("Token đã hết hạn");
        } catch (UnsupportedJwtException ex) {
            System.out.println("Không nhận dạng được Token");
        } catch (IllegalArgumentException ex) {
            System.out.println("Giá trị trích xuất từ Token rỗng.");
        }
        return false;
    }
    //Lấy token từ request
    public static String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        // Kiểm tra xem header Authorization có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}