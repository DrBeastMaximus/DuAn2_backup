package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Product_Detail;
import com.example.backend_final_project.model.Storage;
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
    @Autowired
    private StorageServiceImpl storageService;

    @GetMapping("{productID}")
    public ResponseEntity<?> viewProduct(@PathVariable Integer productID){
        List<Product_Detail> product = productDetaiService.getProductDetailListByProductId(productID);
        return ResponseEntity.ok(product.get(0));
    }

    @GetMapping("/checkStatus/{productID}")
    public ResponseEntity<?> checkStatus(@PathVariable Integer productID){
        List<Storage> storage = storageService.getStorageByProdID(productID);
        int q = storage.get(0).getQuantity();
        if(q>0){
            return ResponseEntity.ok(true);
        } else{
            return ResponseEntity.ok(false);
        }

    }
}
