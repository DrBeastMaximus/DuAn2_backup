package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Product_Property;
import com.example.backend_final_project.service.Impl.ProductPropertyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/productproperty")
public class AdminProduct_PropertyController {
    @Autowired
    private ProductPropertyServiceImpl productPropertyServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("delete",new Product_Property());
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product_Property> getAdmin(){
        List<Product_Property> ds = productPropertyServiceImpl.getProductPropertyList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Product_Property product_Property){
        product_Property.setCreated_date(new Date());
        productPropertyServiceImpl.addProductProperty(product_Property);
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("delete",new Product_Property());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Product_Property product_Property){
        product_Property.setUpdated_date(new Date());
        productPropertyServiceImpl.updateProductProperty(product_Property);
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("delete",new Product_Property());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        productPropertyServiceImpl.deleteProductProperty(id);
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("delete",new Product_Property());
        return "main/tables/tk";

    }
}
