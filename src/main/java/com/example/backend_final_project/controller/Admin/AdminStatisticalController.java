package com.example.backend_final_project.controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/statistical")
public class AdminStatisticalController {

    @GetMapping("home")
    public String home(ModelMap model){
        return "main/tables/charts2";
    }
}
