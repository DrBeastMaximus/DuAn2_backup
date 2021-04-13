package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Supplier;
import com.example.backend_final_project.service.Impl.SupplierServiceImpl;
import com.example.backend_final_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/supplier")
public class AdminSupplierController {
    @Autowired
    private SupplierServiceImpl providerServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        attribute(model);

        return "main/tables/nhacungcap";

    }

    @ModelAttribute
    public void attribute (ModelMap model){
        model.addAttribute("insert",new Supplier());
        model.addAttribute("update",new Supplier());
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Supplier> getSupplier(){
        List<Supplier> ds = providerServiceImpl.getSupplierList();
        return ds;
    }

//    @GetMapping("/insert")
//    public String insert(ModelMap model){
//        model.addAttribute("insert",new Supplier());
//        model.addAttribute("update",new Supplier());
//
//        return "main/tables/nhacungcap";
//    }
//    @GetMapping("/update")
//    public String update(ModelMap model){
//        model.addAttribute("insert",new Supplier());
//        model.addAttribute("update",new Supplier());
//
//        return "main/tables/nhacungcap";
//    }
//    @GetMapping("/delete")
//    public String delete(ModelMap model){
//        model.addAttribute("insert",new Supplier());
//        model.addAttribute("update",new Supplier());
//
//        return "main/tables/nhacungcap";
//    }

    @PostMapping("/insert")
    public String InsertSupplier(ModelMap model, @ModelAttribute Supplier supplier){
        supplier.setCreated_date(new Date());
        supplier.setCreated_by(SessionService.username);
        providerServiceImpl.addSupplier(supplier);
//        model.addAttribute("insert",new Supplier());
//        model.addAttribute("update",new Supplier());
        attribute(model);
//        return "main/tables/nhacungcap";
        return "redirect:/admin/supplier/home";
    }

    @PostMapping("/update")
    public String UpdateSupplier(ModelMap model, @ModelAttribute Supplier supplier){
        supplier.setUpdated_date(new Date());
        supplier.setUpdated_by(SessionService.username);
        providerServiceImpl.updateSupplier(supplier);
//        model.addAttribute("insert",new Supplier());
//        model.addAttribute("update",new Supplier());
        attribute(model);
//        return "main/tables/nhacungcap";
        return "redirect:/admin/supplier/home";
    }

    @PostMapping("delete")
    public String DeleteSupplier(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = providerServiceImpl.deleteSupplier(id_delete);
        if(ketqua == true){

        }else {
            Supplier supplier = providerServiceImpl.getSupplierById(id_delete);
            supplier.setUpdated_date(new Date());
            supplier.setIsdelete(true);
            providerServiceImpl.updateSupplier(supplier);
        }
//        model.addAttribute("insert",new Supplier());
//        model.addAttribute("update",new Supplier());
        attribute(model);
//        return "main/tables/nhacungcap";
        return "redirect:/admin/supplier/home";

    }
}
