package com.example.backend_final_project.service;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    List<User> findUserByKeyword(String keyword);

    User getUserById(int id);

    List<User> getUserList(Pageable pageable);

    List<User> getPagination(int pos, int pageSize);

    long countTotalUsersRecord();

    User getUserByEmail(String email);

    User getUserByUsername(String username);
    User getUserByUsernameNoCheck(String username);
    void addUser(User user);

    void updateUser(User user);

    boolean deleteUser(int userID);


}
