package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.model.Product_Property;
import com.example.backend_final_project.model.Product_Property_Detail;
import com.example.backend_final_project.service.Impl.ProductImageServiceImpl;
import com.example.backend_final_project.service.Impl.ProductPropertyDetailServiceImpl;
import com.example.backend_final_project.service.Impl.ProductPropertyServiceImpl;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import com.example.backend_final_project.service.ProductPropertyDetailService;
import com.example.backend_final_project.service.ProductPropertyService;
import com.example.backend_final_project.service.dto.ProductRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/product")
public class AdminProductController {
    @Autowired
    private ProductPropertyDetailService productPropertyService;
//
//    @Autowired
//    private ProductPropertyDetailServiceImpl productPropertyDetailServiceImpl;

//    @Autowired
//    private ProductPropertyServiceImpl productImageServiceImpl;

    @GetMapping("/list")
    @ResponseBody
    public List<Product_Property_Detail> getProductRespone(){

//        List<ProductRespone> productResponesList = new ArrayList<ProductRespone>();
        List<Product_Property_Detail> list = productPropertyService.getProductPropertyDetailList();
        return list;
    }

}
