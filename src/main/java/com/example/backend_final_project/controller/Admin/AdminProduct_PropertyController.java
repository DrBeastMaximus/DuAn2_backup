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
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product_Property> getAdmin(){
        List<Product_Property> ds = productPropertyServiceImpl.getProductPropertyList();
        return ds;
    }
    @GetMapping("/insert")
    public String insert(ModelMap model){
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }
    @GetMapping("/update")
    public String update(ModelMap model){
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }
    @GetMapping("/delete")
    public String delete(ModelMap model){
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Product_Property product_Property){
        product_Property.setCreated_date(new Date());
        productPropertyServiceImpl.addProductProperty(product_Property);
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Product_Property product_Property){
        System.out.println(product_Property.getID());
        System.out.println(product_Property.getName());
        System.out.println(product_Property.getCreated_date());
        product_Property.setUpdated_date(new Date());
        productPropertyServiceImpl.updateProductProperty(product_Property);
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }

    @PostMapping("delete")
    public String Delete(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = productPropertyServiceImpl.deleteProductProperty(id_delete);
        if(ketqua == true){
            model.addAttribute("message","");
        }else{
            model.addAttribute("message","Xóa thất bại");
        }
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());

        return "main/tables/product_pr";

    }
}
