package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductHotPageREST {

    @Autowired
    private ProductServiceImpl productService;


}
