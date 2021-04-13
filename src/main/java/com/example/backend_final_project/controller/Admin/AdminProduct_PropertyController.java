package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.Product_Property;
import com.example.backend_final_project.service.Impl.ProductPropertyServiceImpl;
import com.example.backend_final_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/productproperty")
public class AdminProduct_PropertyController {
    @Autowired
    private ProductPropertyServiceImpl productPropertyServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        attribute(model);
        model.addAttribute("message","");
        return "main/tables/product_pr";
    }

    @ModelAttribute
    public void attribute(ModelMap model){
        model.addAttribute("insert",new Product_Property());
        model.addAttribute("update",new Product_Property());
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Product_Property> getProductProperty(){
        List<Product_Property> ds = productPropertyServiceImpl.getProductPropertyList();
        return ds;
    }
//    @GetMapping("/insert")
//    public String insert(ModelMap model){
//        model.addAttribute("insert",new Product_Property());
//        model.addAttribute("update",new Product_Property());
//        model.addAttribute("message","");
//        return "main/tables/product_pr";
//    }
//    @GetMapping("/update")
//    public String update(ModelMap model){
//        model.addAttribute("insert",new Product_Property());
//        model.addAttribute("update",new Product_Property());
//        model.addAttribute("message","");
//        return "main/tables/product_pr";
//    }
//    @GetMapping("/delete")
//    public String delete(ModelMap model){
//        model.addAttribute("insert",new Product_Property());
//        model.addAttribute("update",new Product_Property());
//        model.addAttribute("message","");
//        return "main/tables/product_pr";
//    }

    @PostMapping("/insert")
    public String InsertProductProperty(ModelMap model, @ModelAttribute Product_Property product_Property){
        product_Property.setCreated_date(new Date());
        product_Property.setCreated_by(SessionService.username);
        productPropertyServiceImpl.addProductProperty(product_Property);
        attribute(model);
//        model.addAttribute("insert",new Product_Property());
//        model.addAttribute("update",new Product_Property());
        model.addAttribute("message","");
//        return "main/tables/product_pr";
        return "redirect:/admin/productproperty/home";
    }

    @PostMapping("/update")
    public String UpdateProductProperty(ModelMap model, @ModelAttribute Product_Property product_Property){
        System.out.println(product_Property.getID());
        System.out.println(product_Property.getName());
        System.out.println(product_Property.getCreated_date());
        product_Property.setUpdated_date(new Date());
        product_Property.setUpdated_by(SessionService.username);
        productPropertyServiceImpl.updateProductProperty(product_Property);
//        model.addAttribute("insert",new Product_Property());
//        model.addAttribute("update",new Product_Property());
        attribute(model);
        model.addAttribute("message","");
//        return "main/tables/product_pr";
        return "redirect:/admin/productproperty/home";
    }

    @PostMapping("home")
    public String DeleteProductProperty(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = productPropertyServiceImpl.deleteProductProperty(id_delete);
        if(ketqua == true){
            model.addAttribute("message","");
        }else{
            model.addAttribute("message","Xóa thất bại");
        }
//        model.addAttribute("insert",new Product_Property());
//        model.addAttribute("update",new Product_Property());
        attribute(model);
        return "main/tables/product_pr";

    }
}
