package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="prodct_property")
public class Product_Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name ="name")
    private String Name;

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

//    @OneToMany(mappedBy="product_property_detail")
//    private Collection<Product_Property_Detail> Product_Property_Detail;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

//    public Collection<Product_Property_Detail> getProduct_Property_Detail() {
//        return Product_Property_Detail;
//    }
//
//    public void setProduct_Property_Detail(Collection<Product_Property_Detail> product_Property_Detail) {
//        Product_Property_Detail = product_Property_Detail;
//    }

//    public Product_Property(int ID, String name, Date created_date, String created_by, Date updated_date, String updated_by, Collection<Product_Property_Detail> product_Property_Detail) {
//        this.ID = ID;
//        Name = name;
//        Created_date = created_date;
//        Created_by = created_by;
//        Updated_date = updated_date;
//        Updated_by = updated_by;
//        Product_Property_Detail = product_Property_Detail;
//    }


    public Product_Property(int ID, String name, Date created_date, String created_by, Date updated_date, String updated_by) {
        this.ID = ID;
        Name = name;
        Created_date = created_date;
        Created_by = created_by;
        Updated_date = updated_date;
        Updated_by = updated_by;
    }

    public Product_Property() {
    }
}
