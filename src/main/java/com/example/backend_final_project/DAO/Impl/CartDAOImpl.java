package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.CartDAO;
import com.example.backend_final_project.model.Cart;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class CartDAOImpl implements CartDAO {
    @Override
    public List<Cart> getCartList() {
        return null;
    }

    @Override
    public Cart getCartById(int id) {
        return null;
    }

    @Override
    public void addCart(Cart cart) {

    }

    @Override
    public void updateCart(Cart cart) {

    }

    @Override
    public void deleteCart(Cart cart) {

    }
}
