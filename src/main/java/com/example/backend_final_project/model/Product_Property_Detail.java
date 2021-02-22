package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="product_property_detail")
public class Product_Property_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product Product;

    @ManyToOne
    @JoinColumn(name ="product_property_id")
    private Product_Property Product_Property;

    @Column(name ="description")
    private String Description;

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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
    }

    public Product_Property getProduct_Property() {
        return Product_Property;
    }

    public void setProduct_Property(Product_Property product_Property) {
        Product_Property = product_Property;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
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

    public Product_Property_Detail(int ID, Product product, Product_Property product_Property, String description, Date created_date, String created_by, Date updated_date, String updated_by) {
        this.ID = ID;
        Product = product;
        Product_Property = product_Property;
        Description = description;
        Created_date = created_date;
        Created_by = created_by;
        Updated_date = updated_date;
        Updated_by = updated_by;
    }

    public Product_Property_Detail() {
    }
}
