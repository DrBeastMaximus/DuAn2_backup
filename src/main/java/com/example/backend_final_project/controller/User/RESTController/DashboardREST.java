package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.Cart;
import com.example.backend_final_project.model.Cart_Detail;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardREST {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private CartDetailServiceImpl cartDetailService;
    @Autowired
    private InvoiceServiceImpl invoiceService;
    @Autowired
    private InvoiceDetailServiceImpl invoiceDetailService;
    @Autowired
    private VoucherServiceImpl voucherService;

    @GetMapping("/viewInfo")
    public ResponseEntity<?> viewUserInfo(HttpServletRequest request) {
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User user = userService.getUserById(userId);
            if (user != null) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.ok("Không có thông tin!");
            }
        } else{return ResponseEntity.ok("Không có thông tin!");}
    }

    @PostMapping("/updateInfo")
    public ResponseEntity<?> updateUserInfo(@RequestBody User user, HttpServletRequest request) {
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                userService.updateUser(user);
                return ResponseEntity.ok("Đã cập nhật thông tin!");
            } else {
                return ResponseEntity.ok("Cập nhật thông tin thất bại!");
            }
        }{return ResponseEntity.ok("Cập nhật thông tin thất bại!");}
    }

    @PostMapping("/changePassword")
    public ResponseEntity<?> updateUserPassword(@RequestBody JsonNode json, HttpServletRequest request) {
        String token = TokenFactory.getJwtFromRequest(request);
        String oldPass = json.get("oldPassword").asText();
        String newPass = json.get("newPassword").asText();
        String confirm = json.get("confirm").asText();
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                if(oldPass.equals(usr.getPassword())){
                    if(confirm==newPass){
                        userService.updateUser(usr);
                        return ResponseEntity.ok("Đã cập nhật thông tin!");
                    } else{return ResponseEntity.ok("Xác nhận và mật khẩu mới không đúng!");}
                } else {return ResponseEntity.ok("Mật khẩu cũ không hợp lệ!");}
            } else {
                return ResponseEntity.ok("Cập nhật thông tin thất bại!");
            }
        }{return ResponseEntity.ok("Cập nhật thông tin thất bại!");}
    }


}