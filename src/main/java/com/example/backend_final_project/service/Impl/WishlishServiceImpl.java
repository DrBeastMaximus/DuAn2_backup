package com.example.backend_final_project.service.Impl;


import com.example.backend_final_project.DAO.Impl.WishlistDAOImpl;
import com.example.backend_final_project.model.Wishlish;
import com.example.backend_final_project.service.WishlishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WishlishServiceImpl implements WishlishService {
    @Autowired
    private WishlistDAOImpl wishlistDAOlmpl;

    @Override
    public List<Wishlish> getWishlishList() {

        return wishlistDAOlmpl.getWishlishList();
    }

    @Override
    public Wishlish getWishlishById(int id) {

        return wishlistDAOlmpl.getWishlishById(id);
    }

    @Override
    public List<Wishlish> getWishlishByUserID(int userID) {

        return wishlistDAOlmpl.getWishlishByUserID(userID);
    }

    @Override
    public void addWishlish(Wishlish wishlish) {
    wishlistDAOlmpl.addWishlish(wishlish);
    }

    @Override
    public void updateWishlish(Wishlish wishlish) {
    wishlistDAOlmpl.updateWishlish(wishlish);
    }

    @Override
    public void deleteWishlish(Wishlish wishlish) {
    wishlistDAOlmpl.deleteWishlish(wishlish);
    }
}
