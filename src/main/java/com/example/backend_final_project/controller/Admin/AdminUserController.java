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
        model.addAttribute("message","");

        return "main/tables/user";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<User> getAdmin(){
        List<User> ds = userServicelmpl.getUserList();
        return ds;
    }

    @GetMapping("/insert")
    public String insert(ModelMap model){
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("message","");

        return "main/tables/user";
    }
    @GetMapping("/update")
    public String update(ModelMap model){
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("message","");

        return "main/tables/user";
    }

    @GetMapping("/delete")
    public String delete(ModelMap model){
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());
        model.addAttribute("message","");

        return "main/tables/user";
    }




    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute User user){
        User kiemtra = userServicelmpl.getUserByUsernameNoCheck(user.getUsername());
        if(kiemtra !=null){
            if(kiemtra.isIsdelete() == false){
                model.addAttribute("message","User Đã Tồn Tại");
                model.addAttribute("insert", new User());
                model.addAttribute("update", new User());
                return "main/tables/user";
            }else{
                model.addAttribute("message","User Đã Tồn Tại Trong Thùng rác");
                model.addAttribute("insert", new User());
                model.addAttribute("update", new User());
                return "main/tables/user";
            }
        }else {

            user.setCreated_date(new Date());
            userServicelmpl.addUser(user);
            model.addAttribute("message","");
            model.addAttribute("insert", new User());
            model.addAttribute("update", new User());
            return "main/tables/user";
        }
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute User user){
        user.setUpdate_date(new Date());
        userServicelmpl.updateUser(user);
        model.addAttribute("message","");
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());

        return "main/tables/user";
    }

    @PostMapping("/delete")
    public String Delete(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = userServicelmpl.deleteUser(id_delete);
        if(ketqua == true){

        }else{
            User user = userServicelmpl.getUserById(id_delete);
            user.setIsdelete(true);
            user.setUpdate_date(new Date());
            userServicelmpl.updateUser(user);
        }
        model.addAttribute("message","");
        model.addAttribute("insert",new User());
        model.addAttribute("update",new User());

        return "main/tables/user";

    }
}
