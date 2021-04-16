package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.Utils.MailSender;
import com.example.backend_final_project.model.Email;
import com.example.backend_final_project.service.Impl.NewsletterServiceImpl;
import com.example.backend_final_project.service.dto.SendEmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/newsletter")
public class AdminNewsletterController {
    @Autowired
    private NewsletterServiceImpl newsletterServiceImpl;

    // api lấy danh sách email có trong db
    @GetMapping("/list")
    @ResponseBody
    public List<Email> getEmail(){
        List<Email> ds = newsletterServiceImpl.getNewsletterEmailList();
        return ds;
    }

    @ModelAttribute
    public void attribute(ModelMap model){
        model.addAttribute("sendemail",new SendEmailRequest());
        model.addAttribute("insert",new Email());
    }

    //trả về trang quản lí email
    @GetMapping("/home")
    public String Home(ModelMap model){
        attribute(model);

        return "main/tables/email";
    }
//    @GetMapping("/insert")
//    public String insert(ModelMap model){
//        attribute(model);
//
//        return "main/tables/email";
//    }
//    @GetMapping("/delete")
//    public String delete(ModelMap model){
//        attribute(model);
//
//        return "main/tables/email";
//    }

    //gửi email
    @PostMapping("/home")
    public String SendEmail(ModelMap model, @ModelAttribute SendEmailRequest SendEmail) throws MessagingException {
        //lấy danh sách email có trong db
        List<Email> ds = newsletterServiceImpl.getNewsletterEmailList();
        for(int i = 0; i < ds.size(); i++){
            //gửi email cho email ở vị trí i với nội dung và tiêu đề từ SendEmailRequest
            MailSender.sendText(ds.get(i).getEmail(),SendEmail.getSubject(),SendEmail.getMessage());
        }
        attribute(model);
        return "redirect:/admin/newsletter/home";
//        return "main/tables/email";
    }

    //thêm email mới vào db
    @PostMapping("/insert")
    public String InsertEmail(ModelMap model, @ModelAttribute Email email){
        email.setCreated_date(new Date());
        newsletterServiceImpl.addNewsletterEmail(email);
        attribute(model);

//        return "main/tables/email";
        return "redirect:/admin/newsletter/home";
    }


// xóa email khỏi db
    @PostMapping("delete")
    public String DeleteEmail(ModelMap model,@RequestParam("id") int id){
        newsletterServiceImpl.deleteNewsletterEmail(id);
        attribute(model);

//        return "main/tables/email";
        return "redirect:/admin/newsletter/home";

    }
}
