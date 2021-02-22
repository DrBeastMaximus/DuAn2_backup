package com.example.backend_final_project.model;

import com.example.backend_final_project.model.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int ID;

    @Column(name = "code")
    private String Code;

    @Column(name = "name")
    private String Name;

    @Column(name = "price")
    private float Price;

    @Column(name = "price_sale")
    private float Price_slae;

    @Column(name = "description")
    private String Description;

    @ManyToOne()
    @JoinColumn(name = "product_types_id")
    private Product_type productType;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private Brand Brand;

    @Column(name = "issale")
    private boolean Issale;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "ysyyy/MM/dd")
    private Date Created_date;

    @Column(name = "creatd_by")
    private String Creatd_by;

    @Column(name ="isdelete")
    private boolean isdelete;

//    @OneToMany(mappedBy="product_detail",fetch=FetchType.EAGER)
//    private Collection<Product_Detail> Product_Detail;
//   @OneToMany(mappedBy="product_image",fetch=FetchType.EAGER)
//   private Collection<Product_Image> Product_Image;
//
//   @OneToMany(mappedBy = "product_property_detail")
//   private Collection<Product_Property_Detail> Product_Property_Detail;
//
//    @OneToMany(mappedBy="invoice_detail",fetch=FetchType.EAGER)
//    private Collection<Invoice_Detail> Invoice_Detail;
//
//    @OneToMany(mappedBy="cart_detail",fetch=FetchType.EAGER)
//    private Collection<Cart_Detail> Cart_Detail;
//
//    @OneToMany(mappedBy="comment",fetch=FetchType.EAGER)
//    private Collection<Comment> Comment;
//
//    @OneToMany(mappedBy="storage",fetch=FetchType.EAGER)
//    private Collection<Storage> Storage;
//
//    @OneToMany(mappedBy="wishlish",fetch=FetchType.EAGER)
//    private Collection<Wishlish> Wishlish;

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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public float getPrice_slae() {
        return Price_slae;
    }

    public void setPrice_slae(float price_slae) {
        Price_slae = price_slae;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Product_type getProductType() {
        return productType;
    }

    public void setProductType(Product_type productType) {
        this.productType = productType;
    }

    public Brand getBrand() {
        return Brand;
    }

    public void setBrand(Brand brand) {
        Brand = brand;
    }

    public boolean isIssale() {
        return Issale;
    }

    public void setIssale(boolean issale) {
        Issale = issale;
    }

    public Date getCreated_date() {
        return Created_date;
    }

    public void setCreated_date(Date created_date) {
        Created_date = created_date;
    }

    public String getCreatd_by() {
        return Creatd_by;
    }

    public void setCreatd_by(String creatd_by) {
        Creatd_by = creatd_by;
    }

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

//    public Collection<Product_Detail> getProduct_Detail() {
//        return Product_Detail;
//    }
//
//    public void setProduct_Detail(Collection<Product_Detail> product_Detail) {
//        Product_Detail = product_Detail;
//    }
//
//    public Collection<Product_Image> getProduct_Image() {
//        return Product_Image;
//    }
//
//    public void setProduct_Image(Collection<Product_Image> product_Image) {
//        Product_Image = product_Image;
//    }
//
//    public Collection<Product_Property_Detail> getProduct_Property_Detail() {
//        return Product_Property_Detail;
//    }
//
//    public void setProduct_Property_Detail(Collection<Product_Property_Detail> product_Property_Detail) {
//        Product_Property_Detail = product_Property_Detail;
//    }
//
//    public Collection<Invoice_Detail> getInvoice_Detail() {
//        return Invoice_Detail;
//    }
//
//    public void setInvoice_Detail(Collection<Invoice_Detail> invoice_Detail) {
//        Invoice_Detail = invoice_Detail;
//    }
//
//    public Collection<Cart_Detail> getCart_Detail() {
//        return Cart_Detail;
//    }
//
//    public void setCart_Detail(Collection<Cart_Detail> cart_Detail) {
//        Cart_Detail = cart_Detail;
//    }
//
//    public Collection<Comment> getComment() {
//        return Comment;
//    }
//
//    public void setComment(Collection<Comment> comment) {
//        Comment = comment;
//    }
//
//    public Collection<Storage> getStorage() {
//        return Storage;
//    }
//
//    public void setStorage(Collection<Storage> storage) {
//        Storage = storage;
//    }
//
//    public Collection<Wishlish> getWishlish() {
//        return Wishlish;
//    }
//
//    public void setWishlish(Collection<Wishlish> wishlish) {
//        Wishlish = wishlish;
//    }

//    public Product(int ID, String code, String name, float price, float price_slae, String description, Product_type productType, Brand brand, boolean issale, Date created_date, String creatd_by, boolean isdelete, Collection<Product_Detail> product_Detail, Collection<Product_Image> product_Image, Collection<Product_Property_Detail> product_Property_Detail, Collection<Invoice_Detail> invoice_Detail, Collection<Cart_Detail> cart_Detail, Collection<Comment> comment, Collection<Storage> storage, Collection<Wishlish> wishlish) {
//        this.ID = ID;
//        Code = code;
//        Name = name;
//        Price = price;
//        Price_slae = price_slae;
//        Description = description;
//        this.productType = productType;
//        Brand = brand;
//        Issale = issale;
//        Created_date = created_date;
//        Creatd_by = creatd_by;
//        this.isdelete = isdelete;
//        Product_Detail = product_Detail;
//        Product_Image = product_Image;
//        Product_Property_Detail = product_Property_Detail;
//        Invoice_Detail = invoice_Detail;
//        Cart_Detail = cart_Detail;
//        Comment = comment;
//        Storage = storage;
//        Wishlish = wishlish;
//    }

    public Product(int ID, String code, String name, float price, float price_slae, String description, Product_type productType, com.example.backend_final_project.model.Brand brand, boolean issale, Date created_date, String creatd_by, boolean isdelete) {
        this.ID = ID;
        Code = code;
        Name = name;
        Price = price;
        Price_slae = price_slae;
        Description = description;
        this.productType = productType;
        Brand = brand;
        Issale = issale;
        Created_date = created_date;
        Creatd_by = creatd_by;
        this.isdelete = isdelete;
    }

    public Product() {
    }
}
