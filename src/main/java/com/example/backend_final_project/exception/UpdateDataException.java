package com.example.backend_final_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Lỗi! Không thể cập nhật dữ liệu")
public class UpdateDataException extends Exception {
    private static final long serialVersionUID = 1L;

    public UpdateDataException() {
        super();
    }
    public UpdateDataException(String message) {
        super(message);
    }
}

