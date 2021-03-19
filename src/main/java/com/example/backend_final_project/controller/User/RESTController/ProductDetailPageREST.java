package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.service.Impl.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product/detail")
public class ProductDetailPageREST {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private ProductImageServiceImpl productImageService;

    @GetMapping("{productID}")
    public ResponseEntity<?> viewProduct(@PathVariable Integer productID){
        Product product = productService.getProductById(productID);
        List<Product_Image> productImage = productImageService.getProductImageByProdId(productID);
        String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+productID;
        List listImg = new ArrayList();
        for(int i=0;i<productImage.size();i++){
            listImg.add("http://dwhigh.tech:8080/api/image/getImages/"+productID+"/"+i);
        }
        Map<String, Object> obj = new LinkedHashMap<>();

        obj.put("product",product);
        obj.put("indexImage", indexImg);
        obj.put("addtionalImages",listImg);
        return ResponseEntity.ok(obj);
    }

//    @GetMapping("/checkStatus/{productID}")
//    public ResponseEntity<?> checkStatus(@PathVariable Integer productID){
//        List<Storage> storage = storageService.getStorageByProdID(productID);
//        if(storage.size()>0) {
//            int q = storage.get(0).getQuantity();
//            if (q > 0) {
//                return ResponseEntity.ok(true);
//            } else {
//                return ResponseEntity.ok(false);
//            }
//        } else{
//            return ResponseEntity.ok(false);
//        }
//    }
}
