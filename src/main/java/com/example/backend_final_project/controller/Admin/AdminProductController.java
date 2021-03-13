package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.model.Product_Property_Detail;
import com.example.backend_final_project.service.Impl.ProductImageServiceImpl;
import com.example.backend_final_project.service.Impl.ProductPropertyDetailServiceImpl;
import com.example.backend_final_project.service.Impl.ProductPropertyServiceImpl;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import com.example.backend_final_project.service.dto.ProductRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin/product")
public class AdminProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private ProductPropertyDetailServiceImpl productPropertyDetailServiceImpl;

    @Autowired
    private ProductImageServiceImpl productImageServiceImpl;

    @GetMapping("/list")
    @ResponseBody
    public List<ProductRespone> getProductRespone(){
        List<ProductRespone> productResponesList = new ArrayList<ProductRespone>();
        List<Product> product = productServiceImpl.getProductList();
//        System.out.println(productImageServiceImpl.getProductImageByProdId(1));
        System.out.println(productPropertyDetailServiceImpl.getProductPropertyDetailList());
        for(int i = 0; i < product.size();i++){
            ProductRespone productRespones = new ProductRespone();
            List<Product_Property_Detail> product_property_details = productPropertyDetailServiceImpl.getByProductId(product.get(i).getID());
            List<Product_Image> product_images = productImageServiceImpl.getProductImageByProdId(product.get(i).getID());
            productRespones.setProduct(product.get(i));
            productRespones.setProduct_Property_Detail(product_property_details);
            productRespones.setProduct_images(product_images);

            productResponesList.add(productRespones);
        }


        return productResponesList;
    }
}
