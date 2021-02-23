package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Cart_Detail;

import java.util.List;

public interface CartDetailDAO {
    List<Cart_Detail> getCartDetailList();

    Cart_Detail getCartDetailById(int id);

    List<Cart_Detail> getCartDetailListByCardID(int cartID);

    void addCartDetail(Cart_Detail cartD);

    void updateCartDetail(Cart_Detail cartD);

    void deleteCartDetail(int cartDetailID);
}
