package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.CartDetailDAO;
import com.example.backend_final_project.DAO.Impl.CartDAOImpl;
import com.example.backend_final_project.model.Cart_Detail;
import com.example.backend_final_project.service.CartDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CartDetailServiceImpl implements CartDetailService {
    @Autowired
    private CartDetailDAO cartDetailDAOlmpl;

    @Override
    public List<Cart_Detail> getCartDetailList() {
        return cartDetailDAOlmpl.getCartDetailList();
    }

    @Override
    public Cart_Detail getCartDetailId(int id) {
        return cartDetailDAOlmpl.getCartDetailById(id);
    }

    @Override
    public List<Cart_Detail> getCartDetailListByCardID(int id) {
        return cartDetailDAOlmpl.getCartDetailListByCardID(id);
    }

    @Override
    public Cart_Detail extractCartDetail(int cartID, int productID) {
       return cartDetailDAOlmpl.extractCartDetail(cartID,productID);
    }

    @Override
    public void addCartDetail(Cart_Detail cartDetail) {
    cartDetailDAOlmpl.addCartDetail(cartDetail);
    }

    @Override
    public void updateCartDetail(Cart_Detail cartDetail) {
    cartDetailDAOlmpl.updateCartDetail(cartDetail);
    }

    @Override
    public void deleteCartDetail(int cartDetailID) {
    cartDetailDAOlmpl.deleteCartDetail(cartDetailID);
    }
}
