package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.service.Impl.NewsletterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/email")
public class AdminNewsletterController {
    @Autowired
    private NewsletterServiceImpl newsletterServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Email());
        model.addAttribute("update",new Email());
        model.addAttribute("delete",new Email());
           return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Email> getAdmin(){
        List<Email> ds = newsletterServiceImpl.getNewsletterEmailList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Email email){
        email.setCreated_date(new Date());
        newsletterServiceImpl.addNewsletterEmail(email);
        model.addAttribute("insert",new Email());
        model.addAttribute("update",new Email());
        model.addAttribute("delete",new Email());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Email email){

        newsletterServiceImpl.updateNewsletterEmail(email);
        model.addAttribute("insert",new Email());
        model.addAttribute("update",new Email());
        model.addAttribute("delete",new Email());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        newsletterServiceImpl.deleteNewsletterEmail(id);
        model.addAttribute("insert",new Email());
        model.addAttribute("update",new Email());
        model.addAttribute("delete",new Email());
        return "main/tables/tk";

    }
}
