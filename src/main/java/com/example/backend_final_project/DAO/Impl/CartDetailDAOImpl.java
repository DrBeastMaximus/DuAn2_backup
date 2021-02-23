package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.CartDetailDAO;
import com.example.backend_final_project.model.Cart_Detail;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
@EnableTransactionManagement
public class CartDetailDAOImpl implements CartDetailDAO {
    @Override
    public List<Cart_Detail> getCartDetailList() {
        return null;
    }

    @Override
    public Cart_Detail getCartDetailById(int id) {
        return null;
    }

    @Override
    public List<Cart_Detail> getCartDetailListByCardID(int cartID) {
        return null;
    }

    @Override
    public void addCartDetail(Cart_Detail cartD) {

    }

    @Override
    public void updateCartDetail(Cart_Detail cartD) {

    }

    @Override
    public void deleteCartDetail(int cartDetailID) {

    }
}
