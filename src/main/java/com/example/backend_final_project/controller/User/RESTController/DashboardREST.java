package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.*;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardREST {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private ProductServiceImpl productService;
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
    @Autowired
    private CommentServiceImpl commentService;

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
                    if(confirm.equals(newPass)){
                        usr.setPassword(newPass);
                        userService.updateUser(usr);
                        return ResponseEntity.ok("Đã cập nhật thông tin!");
                    } else{return ResponseEntity.ok("Xác nhận và mật khẩu mới không đúng!");}
                } else {return ResponseEntity.ok("Mật khẩu cũ không hợp lệ!");}
            } else {
                return ResponseEntity.ok("Cập nhật thông tin thất bại!");
            }
        }{return ResponseEntity.ok("Cập nhật thông tin thất bại!");}
    }

    @GetMapping("/viewPurchaseHistory")
    public ResponseEntity<?> viewPurchaseHistory(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            List<Invoice> invc = invoiceService.getInvoiceListByUserId(userId);
            List<Invoice_Detail> invcD = new ArrayList<>();
            if (invc.get(0) != null) {
                for(int i=0;i<invc.size();i++){
                    invcD.addAll(invoiceDetailService.getInvoiceDetailListByInvoiceId(invc.get(i).getID()));
                }
                return ResponseEntity.ok(invcD);
            } else {
                return ResponseEntity.ok("Không có lịch sử mua hàng!");
            }
        }{return ResponseEntity.ok("Không có lịch sử mua hàng!");}
    }

    @PostMapping("/rateProduct")
    public ResponseEntity<?> rateProduct(@RequestBody JsonNode json, HttpServletRequest request){
        int productID = json.get("product_id").asInt();
        int rate = json.get("rate").asInt();
        String content = json.get("content").asText();
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            Comment cmt = commentService.getCommentListByProductIdandUserId(productID, userId);
            if (cmt == null) {
                Comment comment = new Comment();
                comment.setUser(userService.getUserById(userId));
                comment.setContent(content);
                comment.setRate(rate);
                comment.setCreated_date(new Date());
                comment.setUpdate_Date(new Date());
                comment.setProduct(productService.getProductById(productID));
                comment.setIsdelete(false);
                commentService.addComment(comment);
                return ResponseEntity.ok("Comment thành công!");
            } else {
                return ResponseEntity.ok("Đã đánh giá mặt hàng này từ trước!");
            }
        } else{return ResponseEntity.ok("Không có lịch sử mua hàng!");}
    }
}