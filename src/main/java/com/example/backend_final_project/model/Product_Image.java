package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name ="product_image")
public class Product_Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name ="image")
    private String Image;

    @Column(name ="proiority")
    private int Proiority;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product Product;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "create_by")
    private String Created_by;

    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Updated_date;

    @Column(name ="update_by")
    private String Updated_by;

    @Column(name ="isdelete")
    private boolean isdelete;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getProiority() {
        return Proiority;
    }

    public void setProiority(int proiority) {
        Proiority = proiority;
    }

    public com.example.backend_final_project.model.Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
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

    public Date getUpdated_date() {
        return Updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        Updated_date = updated_date;
    }

    public String getUpdated_by() {
        return Updated_by;
    }

    public void setUpdated_by(String updated_by) {
        Updated_by = updated_by;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public Product_Image(int ID, String image, int proiority, Product product, Date created_date, String created_by, Date updated_date, String updated_by, boolean isdelete) {
        this.ID = ID;
        Image = image;
        Proiority = proiority;
        Product = product;
        Created_date = created_date;
        Created_by = created_by;
        Updated_date = updated_date;
        Updated_by = updated_by;
        this.isdelete = isdelete;
    }

    public Product_Image() {
    }
}
