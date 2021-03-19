package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Supplier;
import com.example.backend_final_project.service.Impl.SupplierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/provider")
public class AdminProviderController {
    @Autowired
    private SupplierServiceImpl providerServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Supplier());
        model.addAttribute("update",new Supplier());

        return "main/tables/nhacungcap";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Supplier> getAdmin(){
        List<Supplier> ds = providerServiceImpl.getSupplierList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Supplier supplier){
        supplier.setCreated_date(new Date());
        providerServiceImpl.addSupplier(supplier);
        model.addAttribute("insert",new Supplier());
        model.addAttribute("update",new Supplier());

        return "main/tables/nhacungcap";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Supplier supplier){
        supplier.setUpdated_date(new Date());
        providerServiceImpl.updateSupplier(supplier);
        model.addAttribute("insert",new Supplier());
        model.addAttribute("update",new Supplier());

        return "main/tables/nhacungcap";
    }

    @GetMapping("delete")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        Supplier supplier = providerServiceImpl.getSupplierById(id);
        supplier.setUpdated_date(new Date());
        supplier.setIsdelete(true);
        providerServiceImpl.updateSupplier(supplier);
        model.addAttribute("insert",new Supplier());
        model.addAttribute("update",new Supplier());

        return "main/tables/nhacungcap";

    }
}
