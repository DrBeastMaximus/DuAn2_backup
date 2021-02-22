package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="delivery")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

    @ManyToOne
    @JoinColumn(name ="invoice_id")
    private Invoice Invoice;

    @Column(name ="delivery_status")
    private int Delivery_Status;

    @Column(name ="user_note")
    private String User_note;

    @Column(name ="delivery_message")
    private String Delivery_Message;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "updated_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Updated_date;

    @Column(name ="update_by")
    private String Updated_by;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Invoice getInvoice() {
        return Invoice;
    }

    public void setInvoice(Invoice invoice) {
        Invoice = invoice;
    }

    public int getDelivery_Status() {
        return Delivery_Status;
    }

    public void setDelivery_Status(int delivery_Status) {
        Delivery_Status = delivery_Status;
    }

    public String getUser_note() {
        return User_note;
    }

    public void setUser_note(String user_note) {
        User_note = user_note;
    }

    public String getDelivery_Message() {
        return Delivery_Message;
    }

    public void setDelivery_Message(String delivery_Message) {
        Delivery_Message = delivery_Message;
    }

    public Date getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(Date created_date) {
        Created_date = created_date;
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

    public Delivery(int id, Invoice invoice, int delivery_Status, String user_note, String delivery_Message, Date created_date, Date updated_date, String updated_by) {
        Id = id;
        Invoice = invoice;
        Delivery_Status = delivery_Status;
        User_note = user_note;
        Delivery_Message = delivery_Message;
        Created_date = created_date;
        Updated_date = updated_date;
        Updated_by = updated_by;
    }

    public Delivery() {
    }
}
