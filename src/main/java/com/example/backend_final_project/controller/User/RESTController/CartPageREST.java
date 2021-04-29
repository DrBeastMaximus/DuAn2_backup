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
import java.util.*;

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
//Tạo giỏ hàng
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
                    return ResponseEntity.badRequest().body("Giỏ hàng đã có sẵn!");
                }
            } else {return ResponseEntity.badRequest().body("Không có user này!");}
        }else {
            return ResponseEntity.badRequest().body("Tạo giỏ hàng thất bại!");
        }
    }
    //Xem giỏ hàng
    @GetMapping("/viewCart")
    public ResponseEntity<?> viewCart(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                Cart cart = cartService.getCartByUserId(userId);
                if (cart != null) {
                    List<Cart_Detail> cartD = cartDetailService.getCartDetailListByCardID(cart.getId());
                    if (cartD != null || cart != null) {
                        List ls = new ArrayList();
                        for (int i = 0; i < cartD.size(); i++) {
                            Map<String, Object> obj = new LinkedHashMap<>();
                            obj.put("cartDetailID", cartD.get(i).getId());
                            obj.put("cartID", cartD.get(i).getCart().getId());
                            obj.put("product", cartD.get(i).getProduct());
                            obj.put("totalPrice", cartD.get(i).getTotal());
                            obj.put("quantity", cartD.get(i).getQuantity());
                            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/" + cartD.get(i).getProduct().getID();
                            obj.put("indexImage", indexImg);
                            ls.add(obj);
                        }
                        return ResponseEntity.ok(ls);

                    } else {
//                        return ResponseEntity.badRequest().body("Không có hàng trong giỏ!");
                        return ResponseEntity.badRequest().body(null);
                    }
                } else {
//                    return ResponseEntity.badRequest().body("Không có giỏ hàng nào!");
                    return ResponseEntity.badRequest().body(null);
                }
            }
//        }{return ResponseEntity.badRequest().body("Không có giỏ hàng này!");
        }{
            return ResponseEntity.badRequest().body(null);
                }

    }

    //Thêm sản phẩm
    @PutMapping("/addProduct")
    public ResponseEntity<?> addProduct(HttpServletRequest request, @RequestBody JsonNode json){
        int product_id = json.get("product_id").asInt();
        Long total = json.get("total").asLong();
        int quantity = json.get("quantity").asInt();
        Long product_price = json.get("product_price").asLong();
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
                    Product pd = productService.getProductById(product_id);
                    if(pd.getPrice_sale()!=0){
                        cartDetail.setProduct_Price(pd.getPrice_sale());
                    } else{
                        cartDetail.setProduct_Price(pd.getPrice());
                    }

                    cartDetail.setUpdate_Date(new Date());
                    Cart_Detail cd = cartDetailService.extractCartDetail(cart.getId(),product_id);
                        if(cd!=null){
                            cd.setQuantity(cd.getQuantity()+quantity);
                            cd.setTotal(cd.getTotal()+total);
                            cd.setUpdate_Date(new Date());
                            cartDetailService.updateCartDetail(cd);
                        } else {
                            cartDetail.setQuantity(quantity);
                            cartDetail.setTotal(total);
                            cartDetailService.addCartDetail(cartDetail);
                        }


                    cart.setUpdate_Date(new Date());
                    cart.setTotal(cart.getTotal()+total);
                    cartService.updateCart(cart);
                    return ResponseEntity.ok("Đã thêm sản phẩm vào giỏ hàng!");
                } else{
                    return ResponseEntity.badRequest().body("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.badRequest().body("Không có giỏ hàng này!");}

    }
//Cập nhật sản phậm bất kì
    @PutMapping("/updateProduct/{cartDetailID}/{newQuantity}")
    public ResponseEntity<?> updateProduct(HttpServletRequest request,@PathVariable Integer cartDetailID,@PathVariable Integer newQuantity){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            int oldQty = 0;
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                Cart_Detail cartDetail = cartDetailService.getCartDetailId(cartDetailID);
                if(cart!=null){
                    oldQty = cartDetail.getQuantity();
                    cartDetail.setUpdate_Date(new Date());
                    cartDetail.setQuantity(newQuantity);
                    Product pd = productService.getProductById(cartDetail.getProduct().getID());
                    if(pd.getPrice_sale()!=0){
                        cartDetail.setProduct_Price(pd.getPrice_sale());
                        cartDetail.setTotal(pd.getPrice_sale()*newQuantity);
                    } else{
                        cartDetail.setProduct_Price(pd.getPrice());
                        cartDetail.setTotal(pd.getPrice()*newQuantity);
                    }
                    cartDetailService.updateCartDetail(cartDetail);
                    cart.setUpdate_Date(new Date());
                    if(oldQty>newQuantity){
                        cart.setTotal(cart.getTotal()-cartDetail.getProduct_Price());
                    } else{
                        cart.setTotal(cart.getTotal()+cartDetail.getProduct_Price());
                    }
                    cartService.updateCart(cart);
                    return ResponseEntity.ok("Đã cập nhật sản phẩm vào giỏ hàng!");
                } else{
                    return ResponseEntity.badRequest().body("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.badRequest().body("Không có giỏ hàng này!");}
    }
//Xóa sản phẩm bất kì
    @DeleteMapping("/removeProduct/{cartDetailID}")
    public ResponseEntity<?> removeProduct(HttpServletRequest request, @PathVariable int cartDetailID){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                if(cart!=null){
                    Cart_Detail cd = cartDetailService.getCartDetailId(cartDetailID);
                    if(cart.getTotal()>0) {
                        cart.setTotal(cart.getTotal() - cd.getTotal());
                        cartService.updateCart(cart);
                    }
                    cartDetailService.deleteCartDetail(cartDetailID);
                    return ResponseEntity.ok("Đã bỏ sản phẩm khỏi giỏ hàng!");
                } else{
                    return ResponseEntity.badRequest().body("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.badRequest().body("Không có giỏ hàng này!");}
    }
//Xóa sạch giỏ hàng
    @DeleteMapping("/clearCart")
    public ResponseEntity<?> removeAllProduct(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if(usr!=null){
                Cart cart = cartService.getCartByUserId(userId);
                if(cart!=null){
                    List<Cart_Detail> cd = cartDetailService.getCartDetailListByCardID(cart.getId());
                    for(int i = 0;i<cd.size();i++){
                        cartDetailService.deleteCartDetail(cd.get(i).getId());
                    }
                    cartService.deleteCart(cart.getId());
                    return ResponseEntity.ok("Đã bỏ tất cả sản phẩm khỏi giỏ hàng!");
                } else{
                    return ResponseEntity.badRequest().body("Không có giỏ hàng nào!");
                }
            }
        }{return ResponseEntity.badRequest().body("Không có giỏ hàng này!");}
    }
}
