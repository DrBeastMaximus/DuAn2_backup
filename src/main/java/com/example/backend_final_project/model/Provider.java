package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "email")
    private String Email;

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

    @Column(name = "create_by")
    private String Created_by;

    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Updated_date;

    @Column(name = "update_by")
    private String Updated_by;

//    @OneToMany(mappedBy = "Storage", fetch = FetchType.EAGER)
//    private Collection<Storage> Storage;

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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

//    public Collection<Storage> getStorage() {
//        return Storage;
//    }
//
//    public void setStorage(Collection<Storage> storage) {
//        Storage = storage;
//    }

//    public Provider(int id, String name, String email, String phone, String address, boolean isdelete, Date created_date, String created_by, Date updated_date, String updated_by, Collection<Storage> storage) {
//        Id = id;
//        Name = name;
//        Email = email;
//        Phone = phone;
//        Address = address;
//        this.isdelete = isdelete;
//        Created_date = created_date;
//        Created_by = created_by;
//        Updated_date = updated_date;
//        Updated_by = updated_by;
//        Storage = storage;
//    }

    public Provider(int id, String name, String email, String phone, String address, boolean isdelete, Date created_date, String created_by, Date updated_date, String updated_by) {
        Id = id;
        Name = name;
        Email = email;
        Phone = phone;
        Address = address;
        this.isdelete = isdelete;
        Created_date = created_date;
        Created_by = created_by;
        Updated_date = updated_date;
        Updated_by = updated_by;
    }

    public Provider() {
    }
}
