package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.CartDetailServiceImpl;
import com.example.backend_final_project.service.Impl.CartServiceImpl;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartPageREST {
    @Autowired
    private CartServiceImpl cartService;
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private CartDetailServiceImpl cartDetailService;
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/createCart")
    public ResponseEntity<?> createCart(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            Cart c = cartService.getCartByUserId(userId);
            if (usr != null) {
                if (c == null) {
                    Cart cart = new Cart();
                    cart.setUser(usr);
                    cart.setCreated_date(new Date());
                    cart.setUpdate_Date(new Date());
                    cartService.addCart(cart);
                    return ResponseEntity.ok("Đã tạo giỏ hàng!");
                } else {
                    return ResponseEntity.ok("Giỏ hàng đã có sẵn!");
                }
            } else {return ResponseEntity.ok("Không có user này!");}
        }else {
            return ResponseEntity.ok("Tạo giỏ hàng thất bại!");
        }
    }
    @GetMapping("/viewCart")
    public ResponseEntity<?> viewCart(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                if(cart!=null){
                    List<Cart_Detail> cartD = cartDetailService.getCartDetailListByCardID(cart.getId());
                    if(cartD!=null || cart!=null){
                        return ResponseEntity.ok(cartD);
                    } else{
                        return ResponseEntity.ok("Không có hàng trong giỏ!");
                    }
                } else{
                    return ResponseEntity.ok("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.ok("Không có giỏ hàng này!");}

    }


    @PutMapping("/addProduct")
    public ResponseEntity<?> addProduct(HttpServletRequest request, @RequestBody JsonNode json){
        int product_id = json.get("product_id").asInt();
        Float total = json.get("total").floatValue();
        int quantity = json.get("quantity").asInt();
        Float product_price = json.get("product_price").floatValue();
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                if(cart!=null){
                    Cart_Detail cartDetail = new Cart_Detail();
                    cartDetail.setCart(cart);
                    cartDetail.setProduct(productService.getProductById(product_id));
                    cartDetail.setProduct_Price(product_price);
                    cartDetail.setQuantity(quantity);
                    cartDetail.setTotal(total);
                    cartDetail.setUpdate_Date(new Date());
                    cartDetailService.addCartDetail(cartDetail);
                    return ResponseEntity.ok("Đã thêm sản phẩm vào giỏ hàng!");
                } else{
                    return ResponseEntity.ok("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.ok("Không có giỏ hàng này!");}

    }

    @PutMapping("/updateProduct")
    public ResponseEntity<?> updateProduct(HttpServletRequest request,@RequestBody Cart_Detail cartDetail){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                if(cart!=null){
                    cartDetail.setUpdate_Date(new Date());
                    cartDetailService.updateCartDetail(cartDetail);
                    return ResponseEntity.ok("Cập nhật sản phẩm vào giỏ hàng!");
                } else{
                    return ResponseEntity.ok("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.ok("Không có giỏ hàng này!");}
    }

    @DeleteMapping("/removeProduct/{cartDetailID}")
    public ResponseEntity<?> removeProduct(HttpServletRequest request, @PathVariable int cartDetailID){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                if(cart!=null){
                    cartDetailService.deleteCartDetail(cartDetailID);
                    return ResponseEntity.ok("Đã bỏ sản phẩm khỏi giỏ hàng!");
                } else{
                    return ResponseEntity.ok("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.ok("Không có giỏ hàng này!");}
    }
}
