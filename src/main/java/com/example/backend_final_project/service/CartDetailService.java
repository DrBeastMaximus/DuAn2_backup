package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Cart_Detail;

import java.util.List;

public interface CartDetailService {

    List<Cart_Detail> getCartDetailList();

    Cart_Detail getCartDetailId(int id);

    List<Cart_Detail> getCartDetailListByCardID(int id);

    void removeCartDetail(int cartID, int productID);

    void addCartDetail(Cart_Detail cartDetail);

    void updateCartDetail(Cart_Detail cartDetail);

    void deleteCartDetail(int cartDetailID);

}
