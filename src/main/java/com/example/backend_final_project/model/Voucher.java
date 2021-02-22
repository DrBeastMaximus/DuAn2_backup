package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Entity
@Table(name ="voucher")
public class Voucher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name ="code")
    private String Code;

    @Column(name ="value")
    private int Value;

    @Column(name ="status")
    private boolean Status;

    @Column(name ="limit_use")
    private int Limit_use;

    @ManyToOne
    @JoinColumn(name ="product_type_id")
    private Product_type ProductType;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Expiration_date;

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
//
//    @OneToMany(mappedBy="invoice",fetch=FetchType.EAGER)
//    private Collection<Invoice> Invoice;

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

    public int getValue() {
        return Value;
    }

    public void setValue(int value) {
        Value = value;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }

    public int getLimit_use() {
        return Limit_use;
    }

    public void setLimit_use(int limit_use) {
        Limit_use = limit_use;
    }

    public Product_type getProductType() {
        return ProductType;
    }

    public void setProductType(Product_type productType) {
        ProductType = productType;
    }

    public Date getExpiration_date() {
        return Expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        Expiration_date = expiration_date;
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

//    public Collection<Invoice> getInvoice() {
//        return Invoice;
//    }
//
//    public void setInvoice(Collection<Invoice> invoice) {
//        Invoice = invoice;
//    }

//    public Voucher(int ID, String code, int value, boolean status, int limit_use, Product_type productType, Date expiration_date, Date created_date, String created_by, Date updated_date, String updated_by, Collection<Invoice> invoice) {
//        this.ID = ID;
//        Code = code;
//        Value = value;
//        Status = status;
//        Limit_use = limit_use;
//        ProductType = productType;
//        Expiration_date = expiration_date;
//        Created_date = created_date;
//        Created_by = created_by;
//        Updated_date = updated_date;
//        Updated_by = updated_by;
//        Invoice = invoice;
//    }


    public Voucher(int ID, String code, int value, boolean status, int limit_use, Product_type productType, Date expiration_date, Date created_date, String created_by, Date updated_date, String updated_by) {
        this.ID = ID;
        Code = code;
        Value = value;
        Status = status;
        Limit_use = limit_use;
        ProductType = productType;
        Expiration_date = expiration_date;
        Created_date = created_date;
        Created_by = created_by;
        Updated_date = updated_date;
        Updated_by = updated_by;
    }

    public Voucher() {
    }
}
