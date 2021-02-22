package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "product_type")
public class Product_type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "created_by")
    private String Created_by;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_Date;

    @Column(name = "update_by")
    private String Update_by;

    @Column(name = "isdelete")
    private Boolean isdelete;

//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    private Collection<Product> product;

//   @OneToMany(mappedBy="voucher",fetch = FetchType.EAGER)
//   private Collection<Voucher> Voucher;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public Date getUpdate_Date() {
        return Update_Date;
    }

    public void setUpdate_Date(Date update_Date) {
        Update_Date = update_Date;
    }

    public String getUpdate_by() {
        return Update_by;
    }

    public void setUpdate_by(String update_by) {
        Update_by = update_by;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
    }

//    public Collection<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(Collection<Product> product) {
//        this.product = product;
//    }

//    public Collection<Voucher> getVoucher() {
//        return Voucher;
//    }
//
//    public void setVoucher(Collection<Voucher> voucher) {
//        Voucher = voucher;
//    }

//    public Product_type(int id, String name, Date created_date, String created_by, Date update_Date, String update_by, Boolean isdelete, Collection<Product> product, Collection<Voucher> voucher) {
//        Id = id;
//        Name = name;
//        Created_date = created_date;
//        Created_by = created_by;
//        Update_Date = update_Date;
//        Update_by = update_by;
//        this.isdelete = isdelete;
//        this.product = product;
//        Voucher = voucher;
//    }


    public Product_type(int id, String name, Date created_date, String created_by, Date update_Date, String update_by, Boolean isdelete) {
        Id = id;
        Name = name;
        Created_date = created_date;
        Created_by = created_by;
        Update_Date = update_Date;
        Update_by = update_by;
        this.isdelete = isdelete;
    }

    public Product_type() {
    }
}
