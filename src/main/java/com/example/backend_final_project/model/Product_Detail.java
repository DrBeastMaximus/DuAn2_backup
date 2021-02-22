package com.example.backend_final_project.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity()
@Table(name ="product_detail")

public class Product_Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;

  @ManyToOne
  @JoinColumn(name ="product_id")
  private Product Product;

    @Column(name ="content")
    private String Content;

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

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }

  public Product getProduct() {
    return Product;
  }

  public void setProduct(Product product) {
    Product = product;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
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

  public Product_Detail(int id, Product product, String content, Date created_date, String created_by, Date updated_date, String updated_by) {
    Id = id;
    Product = product;
    Content = content;
    Created_date = created_date;
    Created_by = created_by;
    Updated_date = updated_date;
    Updated_by = updated_by;
  }

  public Product_Detail() {
  }
}
