package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.service.Impl.LoginAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/taikhoan")
public class AdminTaiKhoanController {
    @Autowired
    private LoginAdminServiceImpl loginAdminService;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Admin());
        model.addAttribute("update",new Admin());
        model.addAttribute("message","");


        System.out.println(new Date()+ "aaa");
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Admin> getAdmin(){
        List<Admin> ds = loginAdminService.getAdminList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Admin admin){

        Admin admintest = loginAdminService.getAdminUsername(admin.getUsername());
        if(admintest != null){
            if(admintest.isIsdelete() == false ){
                model.addAttribute("insert",new Admin());
                model.addAttribute("update",new Admin());
                model.addAttribute("message","Tài Khoản Đã Tồn Tại");
            }else{
                model.addAttribute("insert",new Admin());
                model.addAttribute("update",new Admin());
                model.addAttribute("message","Tài Khoản Đã Tồn Tại Trong Thùng Rác");
            }
        }else {
            admin.setCreated_date(new Date());
            loginAdminService.addAdmin(admin);
            model.addAttribute("insert", new Admin());
            model.addAttribute("update", new Admin());
        }
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Admin admin){
        admin.setUpdated_date(new Date());
        System.out.println(admin.getID());
        System.out.println(admin.getUsername());
        System.out.println(admin.getRole());
        loginAdminService.updateAdmin(admin);
        model.addAttribute("insert",new Admin());
        model.addAttribute("update",new Admin());
        model.addAttribute("message","");
        System.out.println(admin);
        return "main/tables/tk";
    }

    @GetMapping("/delete")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        Admin admin =  loginAdminService.getAdminId(id);
        admin.setIsdelete(true);
        admin.setUpdated_date(new Date());
        loginAdminService.updateAdmin(admin);
        model.addAttribute("insert",new Admin());
        model.addAttribute("update",new Admin());
        model.addAttribute("messenger","");
        return "main/tables/tk";

    }
    @GetMapping("/testangular")
    public String test(ModelMap model){
        return "index";
    }
}
