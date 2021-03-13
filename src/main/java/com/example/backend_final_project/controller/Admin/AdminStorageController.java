package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Storage;
import com.example.backend_final_project.service.Impl.StorageServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/storage")
public class AdminStorageController {
    private StorageServiceImpl storageServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Storage());
        model.addAttribute("update",new Storage());
        model.addAttribute("delete",new Storage());
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Storage> getAdmin(){
        List<Storage> ds = storageServiceImpl.getStorageList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Storage storage){
        storage.setCreated_date(new Date());
        storageServiceImpl.addStorage(storage);
        model.addAttribute("insert",new Storage());
        model.addAttribute("update",new Storage());
        model.addAttribute("delete",new Storage());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Storage storage){
        storage.setUpdated_date(new Date());
        storageServiceImpl.updateStorage(storage);
        model.addAttribute("insert",new Storage());
        model.addAttribute("update",new Storage());
        model.addAttribute("delete",new Storage());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        storageServiceImpl.deleteStorage(id);
        model.addAttribute("insert",new Storage());
        model.addAttribute("update",new Storage());
        model.addAttribute("delete",new Storage());
        return "main/tables/tk";

    }
}
