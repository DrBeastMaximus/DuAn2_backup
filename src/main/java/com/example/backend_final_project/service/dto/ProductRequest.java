package com.example.backend_final_project.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;

import javax.persistence.TemporalType;
import java.util.Date;

public class ProductRequest {
    private int id;
    private String code;
    private String name;
    private float price;
    private boolean issale;
    private float price_sale;
    private String description;
    private boolean gender;
    private int quantity;
    private String supplier_id;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Created_date;

    private String Created_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isIssale() {
        return issale;
    }

    public void setIssale(boolean issale) {
        this.issale = issale;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Date getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(Date created_date) {
        Created_date = created_date;
    }

    public String getCreated_by() {
        return Created_by;
    }

    public void setCreated_by(String created_by) {
        Created_by = created_by;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice_sale() {
        return price_sale;
    }

    public void setPrice_sale(float price_sale) {
        this.price_sale = price_sale;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public ProductRequest(int id, String code, String name, float price, boolean issale, float price_sale, String description, boolean gender, int quantity, String supplier_id, Date created_date, String created_by) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price = price;
        this.issale = issale;
        this.price_sale = price_sale;
        this.description = description;
        this.gender = gender;
        this.quantity = quantity;
        this.supplier_id = supplier_id;
        Created_date = created_date;
        Created_by = created_by;
    }

    public ProductRequest() {
    }
}
