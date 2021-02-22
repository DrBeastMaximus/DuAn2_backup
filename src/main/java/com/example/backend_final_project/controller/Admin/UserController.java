package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServicelmpl userServicelmpl;

    @GetMapping("")
    public List<User> helloword(){
        List<User>  list = userServicelmpl.getUserList();
        System.out.println("test............");
        return list;
    }
}
