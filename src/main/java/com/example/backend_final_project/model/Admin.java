package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name = "username")
    private String Username;

    @Column(name = "password")
    private String Password;

    @Column(name = "role")
    private int role;

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

    @Column(name = "isdelete")
    private boolean isdelete;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
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

    public Admin(int ID, String username, String password, int role, Date created_date, String created_by, Date updated_date, String updated_by, boolean isdelete) {
        this.ID = ID;
        Username = username;
        Password = password;
        this.role = role;
        Created_date = created_date;
        Created_by = created_by;
        Updated_date = updated_date;
        Updated_by = updated_by;
        this.isdelete = isdelete;
    }

    public Admin() {
    }
}
