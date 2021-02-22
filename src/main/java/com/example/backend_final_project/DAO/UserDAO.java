package com.example.backend_final_project.DAO;

import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUserList();

    List<User> findUserByKeyword(String keyword);

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);
}
