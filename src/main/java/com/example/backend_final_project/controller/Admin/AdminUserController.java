package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/user")
public class AdminUserController {
    @Autowired
    private UserServicelmpl userServicelmpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("delete",new User());
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> getAdmin(){
        List<User> ds = userServicelmpl.getUserList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute User user){
        user.setCreated_date(new Date());
        userServicelmpl.addUser(user);
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("delete",new User());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute User user){
        user.setUpdate_date(new Date());
        userServicelmpl.updateUser(user);
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("delete",new User());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        userServicelmpl.deleteUser(id);
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("delete",new User());
        return "main/tables/tk";

    }
}
