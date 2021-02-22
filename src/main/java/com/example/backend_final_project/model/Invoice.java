package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name ="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name ="code")
    private String Code;

    @Column(name ="total")
    private float Total;

    @ManyToOne
    @JoinColumn(name ="voucher_id")
    private Voucher Voucher;

    @ManyToOne
    @JoinColumn(name ="user_id")
    private User User;

    @Column(name ="payment")
    private String Payment;

    @Column(name="status")
    private int Status;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_Date;

    @Column(name = "update_by")
    private String Update_by;

    @Column(name = "isdelete")
    private Boolean isdelete;

//    @OneToMany(mappedBy="invoice_detail",fetch=FetchType.EAGER)
//    private Collection<Invoice_Detail> Invoice_Detail;

//    @OneToMany(mappedBy="delivery",fetch=FetchType.EAGER)
//    private Collection<Delivery> Delivery;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
    }

    public Voucher getVoucher() {
        return Voucher;
    }

    public void setVoucher(Voucher voucher) {
        Voucher = voucher;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User user) {
        User = user;
    }

    public String getPayment() {
        return Payment;
    }

    public void setPayment(String payment) {
        Payment = payment;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public Date getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(Date created_date) {
        Created_date = created_date;
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

//    public Collection<Invoice_Detail> getInvoice_Detail() {
//        return Invoice_Detail;
//    }
//
//    public void setInvoice_Detail(Collection<Invoice_Detail> invoice_Detail) {
//        Invoice_Detail = invoice_Detail;
//    }

//    public Collection<Delivery> getDelivery() {
//        return Delivery;
//    }
//
//    public void setDelivery(Collection<Delivery> delivery) {
//        Delivery = delivery;
//    }

//    public Invoice(int ID, String code, float total, Voucher voucher, User user, String payment, int status, Date created_date, Date update_Date, String update_by, Boolean isdelete, Collection<Invoice_Detail> invoice_Detail, Collection<Delivery> delivery) {
//        this.ID = ID;
//        Code = code;
//        Total = total;
//        Voucher = voucher;
//        User = user;
//        Payment = payment;
//        Status = status;
//        Created_date = created_date;
//        Update_Date = update_Date;
//        Update_by = update_by;
//        this.isdelete = isdelete;
//        Invoice_Detail = invoice_Detail;
//        Delivery = delivery;
//    }


    public Invoice(int ID, String code, float total, com.example.backend_final_project.model.Voucher voucher, com.example.backend_final_project.model.User user, String payment, int status, Date created_date, Date update_Date, String update_by, Boolean isdelete) {
        this.ID = ID;
        Code = code;
        Total = total;
        Voucher = voucher;
        User = user;
        Payment = payment;
        Status = status;
        Created_date = created_date;
        Update_Date = update_Date;
        Update_by = update_by;
        this.isdelete = isdelete;
    }

    public Invoice() {
    }
}
