package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private   User User;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product product;

    @Column(name ="content")
    private String Content;

    @Column(name ="rate")
    private int Rate;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_Date;

    @Column(name ="isdelete")
    private boolean isdelete;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getCart() {
        return User;
    }

    public void setCart(User cart) {
        User = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
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

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Comment(int id, User user, Product product, String content, int rate, Date created_date, Date update_Date, boolean isdelete) {
        Id = id;
        User = user;
        this.product = product;
        Content = content;
        Rate = rate;
        Created_date = created_date;
        Update_Date = update_Date;
        this.isdelete = isdelete;
    }

    public Comment() {
    }
}
