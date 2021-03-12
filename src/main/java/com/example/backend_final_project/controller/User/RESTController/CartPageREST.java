package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Cart;
import com.example.backend_final_project.model.Cart_Detail;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.CartDetailServiceImpl;
import com.example.backend_final_project.service.Impl.CartServiceImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/createCart")
    public Boolean createCart(@RequestBody Cart cart){
        User usr = userService.getUserById(cart.getUser().getId());
        if(usr!=null){
            cartService.addCart(cart);
            return true;
        } else{
            return false;
        }
    }
    @GetMapping("/viewCart/{idUser}")
    public ResponseEntity<?> viewCart(@PathVariable int idUser){
        Cart cart = cartService.getCartByUserId(idUser);
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


    @PutMapping("/addProduct/{idUser}")
    public Boolean addProduct(@PathVariable int idUser,@RequestBody Cart_Detail cartDetail){
        Cart cart = cartService.getCartByUserId(idUser);
        if(cart!=null){
            cartDetailService.addCartDetail(cartDetail);
            return true;
        } else {
            return false;
        }
    }

    @PutMapping("/updateProduct/{idUser}")
    public Boolean updateProduct(@PathVariable int idUser,@RequestBody Cart_Detail cartDetail){
        Cart cart = cartService.getCartByUserId(idUser);
        if(cart!=null){
            cartDetailService.addCartDetail(cartDetail);
            return true;
        } else {
            return false;
        }
    }

    @DeleteMapping("/removeProduct/{idUser}/{idProduct}")
    public Boolean removeProduct(@PathVariable int idUser, @PathVariable int idProduct){
        Cart cart = cartService.getCartByUserId(idUser);
        if(cart!=null){
            cartDetailService.removeCartDetail(cart.getId(),idProduct);
            return true;
        } else{
            return false;
        }
    }
}
