package com.example.backend_final_project.service.dto;

public class InvoiceRequest {
    private int id;
    private int Status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public InvoiceRequest(int id, int status) {
        this.id = id;
        Status = status;
    }

    public InvoiceRequest() {
    }
}
