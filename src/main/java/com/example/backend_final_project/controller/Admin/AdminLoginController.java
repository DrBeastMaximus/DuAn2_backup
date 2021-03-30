package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.Utils.GlobalConstant;
import com.example.backend_final_project.model.Admin;
import com.example.backend_final_project.service.Impl.LoginAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("admin/login")
public class AdminLoginController {
    @Autowired
    private LoginAdminServiceImpl adminService;

    @GetMapping("/auth")
    public String auth(){
        return "main/pages/login";
    }

    @PostMapping("/auth")
    public String auth(ModelMap mm, @RequestParam(value = "email") String email, @RequestParam(value = "password") String pass ){
        if (email.isEmpty() || pass.isEmpty()) {
            mm.addAttribute("message", "Cannot Auth with empty value!");
            return "main/pages/login";
        } else {
            Admin list = adminService.getAdminUsername(email);
            if (list!=null) {
                if(list.getPassword().equals(pass)){
                    GlobalConstant.setAdminID(list.getID());
                    GlobalConstant.setRole(list.getRole());
                    GlobalConstant.setUsername(list.getUsername());
                    return "redirect:/admin/invoice/home/cho-xac-nhan";
                } else {
                    mm.addAttribute("message", "Wrong username or password!");
                    return "main/pages/login";
                }
            } else {
                mm.addAttribute("message", "Login Authorize Failed, try again or contact System Admin!");
                return "main/pages/login";
            }
        }
    }

    @GetMapping("/logut")
    public void logout(){
        if(GlobalConstant.getUsername()!=null){
            GlobalConstant.returnDefault();
        }
    }
}
