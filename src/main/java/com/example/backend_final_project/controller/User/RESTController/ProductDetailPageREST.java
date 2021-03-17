package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Product_Detail;
import com.example.backend_final_project.service.Impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product/detail")
public class ProductDetailPageREST {
    @Autowired
    private ProductDetailServiceImpl productDetaiService;

    @GetMapping("{productID}")
    public ResponseEntity<?> viewProduct(@PathVariable Integer productID){
        List<Product_Detail> product = productDetaiService.getProductDetailListByProductId(productID);
        return ResponseEntity.ok(product.get(0));
    }
}
