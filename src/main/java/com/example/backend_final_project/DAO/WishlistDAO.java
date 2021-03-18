package com.example.backend_final_project.DAO;

import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.model.Wishlish;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

public interface WishlistDAO {
    List<Wishlish> getWishlishList();

    Wishlish getWishlishById(int id);

    List<Wishlish> getWishlishByUserID(int userID);

    Wishlish getWishlishByUserIDAndProdID(int userID, int prodID);

    void addWishlish(Wishlish wishlish);

    void updateWishlish(Wishlish wishlish);

    void deleteWishlish(int wishlishID);

    @ExceptionHandler({DeleteDataException.class})
    int deleteWishlishByProductID(int userID, int productID);
}
