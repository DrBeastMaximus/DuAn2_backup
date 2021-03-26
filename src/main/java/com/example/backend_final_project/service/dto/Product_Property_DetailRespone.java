package com.example.backend_final_project.service.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class Product_Property_DetailRespone {
    private int id;
    private String id_property;
    private String Description;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date Created_date;

    private String Created_by;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_property() {
        return id_property;
    }

    public void setId_property(String id_property) {
        this.id_property = id_property;
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

    public Product_Property_DetailRespone(int id, String id_property, String description, Date created_date, String created_by) {
        this.id = id;
        this.id_property = id_property;
        Description = description;
        Created_date = created_date;
        Created_by = created_by;
    }

    public Product_Property_DetailRespone() {
    }
}
