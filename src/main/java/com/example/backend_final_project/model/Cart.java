package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User User;

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

//    @OneToMany(mappedBy="cart_detail",fetch=FetchType.EAGER)
//    private Collection<Cart_Detail> Cart_Detail;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
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

//    public Collection<Cart_Detail> getCart_Detail() {
//        return Cart_Detail;
//    }
//
//    public void setCart_Detail(Collection<Cart_Detail> cart_Detail) {
//        Cart_Detail = cart_Detail;
//    }

//    public Cart(int id, User user, float total, Date created_date, Date update_Date, Collection<Cart_Detail> cart_Detail) {
//        Id = id;
//        User = user;
//        Total = total;
//        Created_date = created_date;
//        Update_Date = update_Date;
//        Cart_Detail = cart_Detail;
//    }


    public Cart(int id, com.example.backend_final_project.model.User user, float total, Date created_date, Date update_Date) {
        Id = id;
        User = user;
        Total = total;
        Created_date = created_date;
        Update_Date = update_Date;
    }

    public Cart() {
    }
}
