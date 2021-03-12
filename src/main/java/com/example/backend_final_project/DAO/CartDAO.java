package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Cart;

import java.util.List;

public interface CartDAO {
    List<Cart> getCartList();

    Cart getCartById(int id);

    Cart getCartByUserId(int id);

    void addCart(Cart cart);

    void updateCart(Cart cart);

    void deleteCart(int cartID);
}
