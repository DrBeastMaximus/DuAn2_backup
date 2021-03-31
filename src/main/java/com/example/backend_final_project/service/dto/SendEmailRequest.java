package com.example.backend_final_project.service.dto;

public class SendEmailRequest {
    private  String subject;
    private  String message;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SendEmailRequest(String subject, String message) {
        this.subject = subject;
        this.message = message;
    }

    public SendEmailRequest() {
    }
}
