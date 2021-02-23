package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.ProductDAOlmpl;
import com.example.backend_final_project.DAO.Impl.UserDAOlmpl;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServicelmpl implements UserService {
    @Autowired
    private UserDAOlmpl userDAOlmpl;

    @Override
    public List<User> getUserList() {
        return userDAOlmpl.getUserList();
    }

    @Override
    public List<User> findUserByKeyword(String keyword) {
        return userDAOlmpl.findUserByKeyword(keyword);
    }

    @Override
    public User getUserById(int id) {
        return userDAOlmpl.getUserById(id);
    }


    @Override
    public User getUserByEmail(String email) {
        return userDAOlmpl.getUserByEmail(email);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDAOlmpl.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userDAOlmpl.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAOlmpl.updateUser(user);
    }


    @Override
    public void deleteUser(User user) {
        userDAOlmpl.deleteUser(user);
    }
}
