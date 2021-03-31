package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.service.Impl.StatisticalSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin/statistical")
public class AdminStatisticalController {
    @Autowired
    private StatisticalSeviceImpl statisticalSeviceImpl;

    @GetMapping("totalbill")
    @ResponseBody
    public Object Totalbill(){
        Object object = statisticalSeviceImpl.getCountDHandDT();
        return object;
    }


    @GetMapping("home")
    public String home(ModelMap model){
        return "main/tables/charts2";
    }
}
