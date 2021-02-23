package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getCartList();



    Cart getCartId(int id);

    void addCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCart(Cart cart);
}
