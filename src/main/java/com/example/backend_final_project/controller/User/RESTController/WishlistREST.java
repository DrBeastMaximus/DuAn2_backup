package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.example.backend_final_project.service.Impl.WishlishServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistREST {
    @Autowired
    private WishlishServiceImpl wishlistService;
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private ProductServiceImpl productService;

    @PostMapping("/addToList/{idProduct}")
    public ResponseEntity<?> create(@PathVariable int idProduct, HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                Wishlish wl = new Wishlish();
                wl.setCreated_date(new Date());
                wl.setUpdate_Date(new Date());
                Product prod = productService.getProductById(idProduct);
                wl.setProduct(prod);
                wl.setUser(usr);
                wishlistService.addWishlish(wl);
                return ResponseEntity.ok("Đã cập nhật Wishlist!");
            } else {
                return ResponseEntity.ok("Thêm Wishlist thất bại!");
            }
        }{return ResponseEntity.ok("Thêm Wishlist thất bại!");}
    }


    @PutMapping("/readList")
    public ResponseEntity<?> read(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                List<Wishlish> chk = wishlistService.getWishlishByUserID(userId);
                return ResponseEntity.ok(chk);
            } else {
                return ResponseEntity.ok("Wishlist trống!");
            }
        }{return ResponseEntity.ok("Wishlist trống!");}
    }

    @DeleteMapping("/removeProduct/{idProduct}")
    public ResponseEntity<?> removeProduct(HttpServletRequest request, @PathVariable int idProduct){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                wishlistService.deleteWishlishByProductID(userId,idProduct);
                return ResponseEntity.ok("Remove sản phẩm thành công");
            } else {
                return ResponseEntity.ok("Không thể remove sản phẩm!");
            }
        }{return ResponseEntity.ok("Không thể remove sản phẩm!");}
    }
}
