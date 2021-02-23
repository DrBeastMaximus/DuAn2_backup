package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.CartDAOImpl;
import com.example.backend_final_project.model.Cart;
import com.example.backend_final_project.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDAOImpl cartDAOlmpl;

    @Override
    public List<Cart> getCartList()
    {
        return cartDAOlmpl.getCartList();
    }

    @Override
    public Cart getCartId(int id) {
        return cartDAOlmpl.getCartById(id);
    }

    @Override
    public void addCart(Cart cart) {
    cartDAOlmpl.addCart(cart);
    }

    @Override
    public void updateCart(Cart cart) {
    cartDAOlmpl.updateCart(cart);
    }

    @Override
    public void deleteCart(int cartID) {
    cartDAOlmpl.deleteCart(cartID);
    }
}
