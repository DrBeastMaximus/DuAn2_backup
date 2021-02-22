package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "brand")
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "description")
    private String Description;

    @Column(name = "logo")
    private String Logo;

    @Column(name = "isdelete")
    private Boolean isdelete;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "created_by")
    private String Created_by;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_date;

    @Column(name = "update_by")
    private String Update_by;

//    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
//    private Collection<Product> product;

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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        Logo = logo;
    }

    public Boolean getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Boolean isdelete) {
        this.isdelete = isdelete;
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

    public Date getUpdate_date() {
        return Update_date;
    }

    public void setUpdate_date(Date update_date) {
        Update_date = update_date;
    }

    public String getUpdate_by() {
        return Update_by;
    }

    public void setUpdate_by(String update_by) {
        Update_by = update_by;
    }

//    public Collection<Product> getProduct() {
//        return product;
//    }
//
//    public void setProduct(Collection<Product> product) {
//        this.product = product;
//    }

//    public Brand(int id, String name, String description, String logo, Boolean isdelete, Date created_date, String created_by, Date update_date, String update_by, Collection<Product> product) {
//        Id = id;
//        Name = name;
//        Description = description;
//        Logo = logo;
//        this.isdelete = isdelete;
//        Created_date = created_date;
//        Created_by = created_by;
//        Update_date = update_date;
//        Update_by = update_by;
//        this.product = product;
//    }

    public Brand(int id, String name, String description, String logo, Boolean isdelete, Date created_date, String created_by, Date update_date, String update_by) {
        Id = id;
        Name = name;
        Description = description;
        Logo = logo;
        this.isdelete = isdelete;
        Created_date = created_date;
        Created_by = created_by;
        Update_date = update_date;
        Update_by = update_by;
    }

    public Brand() {
    }
}
