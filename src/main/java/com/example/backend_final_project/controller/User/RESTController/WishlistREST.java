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

    @GetMapping("/addToList/{idProduct}")
    public ResponseEntity<?> create(@PathVariable int idProduct, HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            Wishlish wls = wishlistService.getWishlishByUserIDAndProdID(userId,idProduct);
            if (usr != null) {
                if(wls==null) {
                    Wishlish wl = new Wishlish();
                    wl.setCreated_date(new Date());
                    wl.setUpdate_Date(new Date());
                    Product prod = productService.getProductById(idProduct);
                    wl.setProduct(prod);
                    wl.setUser(usr);
                    wishlistService.addWishlish(wl);
                    return ResponseEntity.ok("Đã cập nhật Wishlist!");
                } else {return ResponseEntity.badRequest().body("Sản phẩm đã có trong Wishlist!");}
            } else {
                return ResponseEntity.badRequest().body("Thêm Wishlist thất bại!");
            }
        }{return ResponseEntity.badRequest().body("Thêm Wishlist thất bại!");}
    }


    @GetMapping("/readList")
    public ResponseEntity<?> read(HttpServletRequest request){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                List<Wishlish> chk = wishlistService.getWishlishByUserID(userId);
                return ResponseEntity.ok(chk);
            } else {
                return ResponseEntity.badRequest().body("Wishlist trống!");
            }
        }{return ResponseEntity.badRequest().body("Wishlist trống!");}
    }

    @DeleteMapping("/removeProduct/{wishlistID}")
    public ResponseEntity<?> removeProduct(HttpServletRequest request, @PathVariable int wishlistID){
        String token = TokenFactory.getJwtFromRequest(request);
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                        wishlistService.deleteWishlish(wishlistID);
                        return ResponseEntity.ok("Remove sản phẩm thành công");
            } else {
                return ResponseEntity.badRequest().body("Không thể remove sản phẩm!");
            }
        }{return ResponseEntity.badRequest().body("Không thể remove sản phẩm!");}
    }
}
