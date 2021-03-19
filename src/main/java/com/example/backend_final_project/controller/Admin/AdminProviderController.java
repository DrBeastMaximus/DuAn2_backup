package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Provider;
import com.example.backend_final_project.model.Voucher;
import com.example.backend_final_project.service.Impl.ProviderServiceImpl;
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
    private ProviderServiceImpl providerServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Provider());
        model.addAttribute("update",new Provider());

        return "main/tables/nhacungcap";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Provider> getAdmin(){
        List<Provider> ds = providerServiceImpl.getProviderList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Provider provider){
        provider.setCreated_date(new Date());
        providerServiceImpl.addProvider(provider);
        model.addAttribute("insert",new Provider());
        model.addAttribute("update",new Provider());

        return "main/tables/nhacungcap";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Provider provider){
        provider.setUpdated_date(new Date());
        providerServiceImpl.updateProvider(provider);
        model.addAttribute("insert",new Provider());
        model.addAttribute("update",new Provider());

        return "main/tables/nhacungcap";
    }

    @GetMapping("delete")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        Provider provider = providerServiceImpl.getProviderById(id);
        provider.setUpdated_date(new Date());
        provider.setIsdelete(true);
        providerServiceImpl.updateProvider(provider);
        model.addAttribute("insert",new Provider());
        model.addAttribute("update",new Provider());

        return "main/tables/nhacungcap";

    }
}
