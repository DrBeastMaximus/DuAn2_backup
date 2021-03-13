package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.Product_type;
import com.example.backend_final_project.service.Impl.ProductTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/producttype")
public class AdminProduct_TypeController {
    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Product_type());
        model.addAttribute("update",new Product_type());
        model.addAttribute("delete",new Product_type());
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product_type> getAdmin(){
        List<Product_type> ds = productTypeService.getProductTypeList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Product_type product_type){
        product_type.setCreated_date(new Date());
        productTypeService.addProductType(product_type);
        model.addAttribute("insert",new Product_type());
        model.addAttribute("update",new Product_type());
        model.addAttribute("delete",new Product_type());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Product_type product_type){
        product_type.setUpdate_Date(new Date());
        productTypeService.updateProductType(product_type);
        model.addAttribute("insert",new Product_type());
        model.addAttribute("update",new Product_type());
        model.addAttribute("delete",new Product_type());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        productTypeService.deleteProductType(id);
        model.addAttribute("insert",new Product_type());
        model.addAttribute("update",new Product_type());
        model.addAttribute("delete",new Product_type());
        return "main/tables/tk";

    }
}
