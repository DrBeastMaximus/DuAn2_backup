package com.example.backend_final_project.service.dto;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.model.Product_Property_Detail;

import java.util.List;

public class ProductRespone {
    private Product product;
    private List<Product_Property_Detail> product_Property_Detail;
    private List<Product_Image> product_images;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product_Property_Detail> getProduct_Property_Detail() {
        return product_Property_Detail;
    }

    public void setProduct_Property_Detail(List<Product_Property_Detail> product_Property_Detail) {
        this.product_Property_Detail = product_Property_Detail;
    }

    public List<Product_Image> getProduct_images() {
        return product_images;
    }

    public void setProduct_images(List<Product_Image> product_images) {
        this.product_images = product_images;
    }

    public ProductRespone(Product product, List<Product_Property_Detail> product_Property_Detail, List<Product_Image> product_images) {
        this.product = product;
        this.product_Property_Detail = product_Property_Detail;
        this.product_images = product_images;
    }

    public ProductRespone() {
    }
}
