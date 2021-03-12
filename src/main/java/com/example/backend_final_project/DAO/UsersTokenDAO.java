package com.example.backend_final_project.DAO;

import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.exception.UpdateDataException;
import com.example.backend_final_project.model.UsersToken;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface UsersTokenDAO {
    UsersToken getUserTokenByID(int idToken);

    UsersToken getUserTokenByUID(int idUser);

    @ExceptionHandler({SaveDataErrorException.class})
    void addToken(UsersToken token);

    @ExceptionHandler({UpdateDataException.class})
    void updateToken(UsersToken token);

    @ExceptionHandler({DeleteDataException.class})
    void deleteToken(int userID);
}
