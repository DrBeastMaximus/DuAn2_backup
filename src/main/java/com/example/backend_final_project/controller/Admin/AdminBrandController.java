package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Brand;
import com.example.backend_final_project.service.Impl.BrandServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/brand")
public class AdminBrandController {
    @Autowired
    private BrandServiceImpl brandServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Brand());
        model.addAttribute("update",new Brand());
        model.addAttribute("delete",new Brand());
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Brand> getAdmin(){
        List<Brand> ds = brandServiceImpl.getBrandList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Brand brand){
        brand.setCreated_date(new Date());
        brandServiceImpl.addBrand(brand);
        model.addAttribute("insert",new Brand());
        model.addAttribute("update",new Brand());
        model.addAttribute("delete",new Brand());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Brand brand){
        brand.setUpdate_date(new Date());
        brandServiceImpl.updateBrand(brand);
        model.addAttribute("insert",new Brand());
        model.addAttribute("update",new Brand());
        model.addAttribute("delete",new Brand());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        brandServiceImpl.deleteBrand(id);
        model.addAttribute("insert",new Brand());
        model.addAttribute("update",new Brand());
        model.addAttribute("delete",new Brand());
        return "main/tables/tk";

    }


}
