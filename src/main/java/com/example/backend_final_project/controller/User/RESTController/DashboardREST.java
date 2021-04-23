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
import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardREST {

    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private InvoiceServiceImpl invoiceService;
    @Autowired
    private InvoiceDetailServiceImpl invoiceDetailService;
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
                return ResponseEntity.badRequest().body("Không có thông tin!");
            }
        } else{return ResponseEntity.badRequest().body("Không có thông tin!");}
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
                return ResponseEntity.badRequest().body("Cập nhật thông tin thất bại!");
            }
        }{return ResponseEntity.badRequest().body("Cập nhật thông tin thất bại!");}
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
                    } else{return ResponseEntity.badRequest().body("Xác nhận và mật khẩu mới không đúng!");}
                } else {return ResponseEntity.badRequest().body("Mật khẩu cũ không hợp lệ!");}
            } else {
                return ResponseEntity.badRequest().body("Cập nhật thông tin thất bại!");
            }
        }{return ResponseEntity.badRequest().body("Cập nhật thông tin thất bại!");}
    }

    @GetMapping("/viewPurchaseHistory")
    public ResponseEntity<?> viewPurchaseHistory(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            List<Invoice> invc = invoiceService.getInvoiceListByUserId(userId);
            List<Invoice_Detail> invcD = new ArrayList<>();
            if (invc.size() != 0) {
                for(int i=0;i<invc.size();i++){
                    invcD.addAll(invoiceDetailService.getInvoiceDetailListByInvoiceId(invc.get(i).getID()));
                }
                //Gather to JSON format
                List ls = new ArrayList();
                for(int i=0;i<invcD.size();i++){
                    Map<String, Object> obj = new LinkedHashMap<>();
                    obj.put("history_purchase",invcD.get(i));
                    String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+invcD.get(i).getProduct().getID();
                    obj.put("indexImage",indexImg);
                    ls.add(obj);
                }
                return ResponseEntity.ok(ls);
                ///
//                return ResponseEntity.ok(invcD);
            } else {
                return ResponseEntity.badRequest().body("Không có lịch sử mua hàng!");
            }
        }{return ResponseEntity.badRequest().body("Không có lịch sử mua hàng!");}
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
                return ResponseEntity.badRequest().body("Đã đánh giá mặt hàng này từ trước!");
            }
        } else{return ResponseEntity.badRequest().body("Không có lịch sử mua hàng!");}
    }
}