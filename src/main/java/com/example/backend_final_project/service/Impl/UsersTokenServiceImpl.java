package com.example.backend_final_project.service.Impl;

import com.example.backend_final_project.DAO.Impl.UsersTokenDAOImpl;
import com.example.backend_final_project.model.UsersToken;
import com.example.backend_final_project.service.UsersTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsersTokenServiceImpl implements UsersTokenService {
    @Autowired
    private UsersTokenDAOImpl userTokenDAO;
    @Override
    public UsersToken getUserTokenByID(int idToken) {
        return userTokenDAO.getUserTokenByID(idToken);
    }

    @Override
    public UsersToken getUserTokenByUID(int idUser) {
        return userTokenDAO.getUserTokenByUID(idUser);
    }

    @Override
    public void addToken(UsersToken token) {
        userTokenDAO.addToken(token);
    }

    @Override
    public void updateToken(UsersToken token) {
        userTokenDAO.updateToken(token);
    }

    @Override
    public void deleteToken(int userID) {
        userTokenDAO.deleteToken(userID);
    }
}
