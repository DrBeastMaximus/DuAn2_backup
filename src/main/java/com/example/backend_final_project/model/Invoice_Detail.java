package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="invoice_detail")
public class Invoice_Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @ManyToOne
    @JoinColumn(name ="invoice_id")
    private Invoice Invoice;

    @ManyToOne
    @JoinColumn(name ="product_id")
    private Product Product;

    @Column(name ="product_price")
    private int Product_Price;

    @Column(name ="quantity")
    private int Quantity;

    @Column(name ="total")
    private float Total;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Created_date;

    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date Update_Date;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Invoice getInvoice() {
        return Invoice;
    }

    public void setInvoice(Invoice invoice) {
        Invoice = invoice;
    }

    public Product getProduct() {
        return Product;
    }

    public void setProduct(Product product) {
        Product = product;
    }

    public int getProduct_Price() {
        return Product_Price;
    }

    public void setProduct_Price(int product_Price) {
        Product_Price = product_Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float total) {
        Total = total;
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

    public Invoice_Detail(int ID, Invoice invoice, Product product, int product_Price, int quantity, float total, Date created_date, Date update_Date) {
        this.ID = ID;
        Invoice = invoice;
        Product = product;
        Product_Price = product_Price;
        Quantity = quantity;
        Total = total;
        Created_date = created_date;
        Update_Date = update_Date;
    }

    public Invoice_Detail() {
    }
}
