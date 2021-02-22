package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("")
    public List<Product> helloword(){
        List<Product>  list = productServiceImpl.getProductList();
        System.out.println("test............");
        return list;
    }


}
