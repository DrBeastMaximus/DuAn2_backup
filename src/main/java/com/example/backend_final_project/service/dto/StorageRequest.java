package com.example.backend_final_project.service.dto;

import java.util.Date;

public class StorageRequest {
    private int id;
    private String Id_product;
    private String Id_supplier;
    private int Quantity;

    private String Created_date;

    private String Created_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_product() {
        return Id_product;
    }

    public void setId_product(String id_product) {
        Id_product = id_product;
    }

    public String getId_supplier() {
        return Id_supplier;
    }

    public void setId_supplier(String id_supplier) {
        Id_supplier = id_supplier;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public String getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(String created_date) {
        Created_date = created_date;
    }

    public String getCreated_by() {
        return Created_by;
    }

    public void setCreated_by(String created_by) {
        Created_by = created_by;
    }

    public StorageRequest(int id, String id_product, String id_supplier, int quantity, String created_date, String created_by) {
        this.id = id;
        Id_product = id_product;
        Id_supplier = id_supplier;
        Quantity = quantity;
        Created_date = created_date;
        Created_by = created_by;
    }

    public StorageRequest() {
    }
}
