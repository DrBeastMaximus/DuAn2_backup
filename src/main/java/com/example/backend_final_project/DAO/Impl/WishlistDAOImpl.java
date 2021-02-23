package com.example.backend_final_project.DAO.Impl;

import com.example.backend_final_project.DAO.WishlistDAO;
import com.example.backend_final_project.model.Wishlish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
@EnableTransactionManagement
public class WishlistDAOImpl implements WishlistDAO {
    @Override
    public List<Wishlish> getWishlishList() {
        return null;
    }

    @Override
    public Wishlish getWishlishById(int id) {
        return null;
    }

    @Override
    public List<Wishlish> getWishlishByUserID(int userID) {
        return null;
    }

    @Override
    public void addWishlish(Wishlish wishlish) {

    }

    @Override
    public void updateWishlish(Wishlish wishlish) {

    }

    @Override
    public void deleteWishlish(Wishlish wishlish) {

    }
}
