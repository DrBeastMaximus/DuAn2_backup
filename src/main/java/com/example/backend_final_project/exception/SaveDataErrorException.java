package com.example.backend_final_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Lỗi! Không thể lưu dữ liệu")
public class SaveDataErrorException extends Exception {
    private static final long serialVersionUID = 1L;

    public SaveDataErrorException() {
        super();
    }
    public SaveDataErrorException(String message) {
        super(message);
    }
}
