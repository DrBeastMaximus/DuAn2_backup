package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    List<User> findUserByKeyword(String keyword);

    User getUserId(int id);

    User getUserByEmail(int email);

    User getUserByUsername(String username);

    void addUser(User user);

    void editUser(User user);

    void deleteUser(User user);
}
