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
    public User getUserId(int id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void editUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
