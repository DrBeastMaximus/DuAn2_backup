package com.example.backend_final_project.service.dto;

public class Invoice_detetailRespone {
    private int id;
    private String product_name;
    private float product_price;
    private int quantity;
    private float price_sale;
    private float total;

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice_sale() {
        return price_sale;
    }

    public void setPrice_sale(float price_sale) {
        this.price_sale = price_sale;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Invoice_detetailRespone(int id, String product_name, float product_price, int quantity, float price_sale, float total) {
        this.id = id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.quantity = quantity;
        this.price_sale = price_sale;
        this.total = total;
    }

    public Invoice_detetailRespone() {
    }
}
