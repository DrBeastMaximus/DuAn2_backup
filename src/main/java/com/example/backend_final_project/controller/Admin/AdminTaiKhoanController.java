package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.service.Impl.LoginAdminServiceImpl;
import com.example.backend_final_project.service.SessionService;
import org.codehaus.jackson.map.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/taikhoan")
public class AdminTaiKhoanController {
    @Autowired
    private LoginAdminServiceImpl loginAdminService;

    //trả về trang quản lý tài khoản
    @GetMapping("/home")
    public String Home(ModelMap model){
        attributr(model);

        model.addAttribute("message","");



        return "main/tables/tk";
    }

    //api trả về danh sách admin có trong db với trạng thái chưa xóa
    @GetMapping("/list")
    @ResponseBody
    public List<Admin> getAdmin(){
        List<Admin> ds = loginAdminService.getAdminList();
        return ds;
    }

    @ModelAttribute
    public void attributr(ModelMap model){
        model.addAttribute("insert",new Admin());
        model.addAttribute("update",new Admin());
    }
    //    @GetMapping("/insert")
//    public String insert(ModelMap model){
//        model.addAttribute("insert",new Admin());
//        model.addAttribute("update",new Admin());
//
//        model.addAttribute("message","");
//
//
//
//        return "main/tables/tk";
//    }
//
//    @GetMapping("/update")
//    public String update(ModelMap model){
//        model.addAttribute("insert",new Admin());
//        model.addAttribute("update",new Admin());
//
//        model.addAttribute("message","");
//
//
//
//        return "main/tables/tk";
//    }
//    @GetMapping("/delete")
//    public String delete(ModelMap model){
//        model.addAttribute("insert",new Admin());
//        model.addAttribute("update",new Admin());
//
//        model.addAttribute("message","");
//
//
//
//        return "main/tables/tk";
//    }

    //thêm tài khoản vào db
    @PostMapping("/home")
    public String InsertAdmin(ModelMap model, @ModelAttribute Admin admin){

        Admin admintest = loginAdminService.getAdminUsername(admin.getUsername());
        if(admintest != null){
            if(admintest.isIsdelete() == false ){
//                model.addAttribute("insert",new Admin());
//                model.addAttribute("update",new Admin());
                attributr(model);
                model.addAttribute("message","Tài Khoản Đã Tồn Tại");
            }else{
//                model.addAttribute("insert",new Admin());
//                model.addAttribute("update",new Admin());
                attributr(model);
                model.addAttribute("message","Tài Khoản Đã Tồn Tại Trong Thùng Rác");
            }
        }else {
            admin.setCreated_date(new Date());
            admin.setCreated_by(SessionService.username);
            loginAdminService.addAdmin(admin);
//            model.addAttribute("insert", new Admin());
//            model.addAttribute("update", new Admin());
            attributr(model);
        }
//        return "redirect:/admin/taikhoan/home";
        return "main/tables/tk";
    }

    // cập nhật tài khoản
    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Admin admin){
        admin.setUpdated_date(new Date());
        admin.setUpdated_by(SessionService.username);
        loginAdminService.updateAdmin(admin);
//        model.addAttribute("insert",new Admin());
//        model.addAttribute("update",new Admin());
        attributr(model);
        model.addAttribute("message","");
        System.out.println(admin);
//        return "main/tables/tk";
        return "redirect:/admin/taikhoan/home";
    }

    // xóa tài khoản
    @PostMapping("/delete")
    public String DeleteAdmin(ModelMap model,@RequestParam("id_delete") int id_delete){

        Admin admin =  loginAdminService.getAdminId(id_delete);
        admin.setIsdelete(true);
        admin.setUpdated_date(new Date());
        admin.setUpdated_by(SessionService.username);
        loginAdminService.updateAdmin(admin);
//        model.addAttribute("insert",new Admin());
//        model.addAttribute("update",new Admin());
        attributr(model);
        model.addAttribute("messenger","");
//        return "main/tables/tk";
        return "redirect:/admin/taikhoan/home";

    }
//    @GetMapping("/taikhoan_restore")
//    public String test(ModelMap model){
//        return "main/tables/tk_restore";
//    }
}
