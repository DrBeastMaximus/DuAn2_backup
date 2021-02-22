package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="cart_detail")
public class Cart_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @ManyToOne
    @JoinColumn(name ="cart_id")
    private Cart Cart;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;

    @Column(name ="product_price")
    private float Product_Price;

    @Column(name="quantity")
    private int Quantity;

    @Column(name ="total")
    private float Total;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_Date;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Cart getCart() {
        return Cart;
    }

    public void setCart(Cart cart) {
        Cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(float product_Price) {
        Product_Price = product_Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    public Date getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(Date created_date) {
        Created_date = created_date;
    }

    public Date getUpdate_Date() {
        return Update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        Update_Date = update_Date;
    }

    public Cart_Detail(int id, Cart cart, Product product, float product_Price, int quantity, float total, Date created_date, Date update_Date) {
        Id = id;
        Cart = cart;
        this.product = product;
        Product_Price = product_Price;
        Quantity = quantity;
        Total = total;
        Created_date = created_date;
        Update_Date = update_Date;
    }

    public Cart_Detail() {
    }
}
