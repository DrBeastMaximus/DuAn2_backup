package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "username")
    private String Username;

    @Column(name = "password")
    private String Password;

    @Column(name = "email")
    private String Email;

    @Column(name = "fullname")
    private String Fullname;

    @Column(name = "gender")
    private boolean Gender;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Birthday;

    @Column(name = "phone")
    private String Phone;

    @Column(name = "address")
    private String Address;

    @Column(name = "isdelete")
    private boolean isdelete;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_date;

//   @OneToMany(mappedBy="invoice",fetch=FetchType.EAGER)
//    private Collection<Invoice> Invoice;
//
//    @OneToMany(mappedBy="cart",fetch=FetchType.EAGER)
//    private Collection<Cart> Cart;
//
//    @OneToMany(mappedBy="comment",fetch=FetchType.EAGER)
//    private Collection<Comment> Comment;
//
//    @OneToMany(mappedBy="wishlish",fetch=FetchType.EAGER)
//    private Collection<Wishlish> Wishlish;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date birthday) {
        Birthday = birthday;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Date getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(Date created_date) {
        Created_date = created_date;
    }

    public Date getUpdate_date() {
        return Update_date;
    }

    public void setUpdate_date(Date update_date) {
        Update_date = update_date;
    }

//    public Collection<Invoice> getInvoice() {
//        return Invoice;
//    }
//
//    public void setInvoice(Collection<Invoice> invoice) {
//        Invoice = invoice;
//    }
//
//    public Collection<Cart> getCart() {
//        return Cart;
//    }
//
//    public void setCart(Collection<Cart> cart) {
//        Cart = cart;
//    }
//
//    public Collection<Comment> getComment() {
//        return Comment;
//    }
//
//    public void setComment(Collection<Comment> comment) {
//        Comment = comment;
//    }
//
//    public Collection<Wishlish> getWishlish() {
//        return Wishlish;
//    }
//
//    public void setWishlish(Collection<Wishlish> wishlish) {
//        Wishlish = wishlish;
//    }

//    public User(int id, String username, String password, String email, String fullname, boolean gender, Date birthday, String phone, String address, boolean isdelete, Date created_date, Date update_date, Collection<Invoice> invoice, Collection<Cart> cart, Collection<Comment> comment, Collection<Wishlish> wishlish) {
//        Id = id;
//        Username = username;
//        Password = password;
//        Email = email;
//        Fullname = fullname;
//        Gender = gender;
//        Birthday = birthday;
//        Phone = phone;
//        Address = address;
//        this.isdelete = isdelete;
//        Created_date = created_date;
//        Update_date = update_date;
//        Invoice = invoice;
//        Cart = cart;
//        Comment = comment;
//        Wishlish = wishlish;
//    }


    public User(int id, String username, String password, String email, String fullname, boolean gender, Date birthday, String phone, String address, boolean isdelete, Date created_date, Date update_date) {
        Id = id;
        Username = username;
        Password = password;
        Email = email;
        Fullname = fullname;
        Gender = gender;
        Birthday = birthday;
        Phone = phone;
        Address = address;
        this.isdelete = isdelete;
        Created_date = created_date;
        Update_date = update_date;
    }

    public User() {
    }
}
