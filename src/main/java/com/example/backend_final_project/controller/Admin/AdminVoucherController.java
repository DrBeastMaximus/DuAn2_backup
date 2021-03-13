package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.Voucher;
import com.example.backend_final_project.service.Impl.VoucherServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/voucher")
public class AdminVoucherController {
    private VoucherServiceImpl voucherServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("delete",new Voucher());
        return "main/tables/tk";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Voucher> getAdmin(){
        List<Voucher> ds = voucherServiceImpl.getVoucherList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Voucher voucher){
        voucher.setCreated_date(new Date());
        voucherServiceImpl.addVoucher(voucher);
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("delete",new Voucher());
        return "main/tables/tk";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Voucher voucher){
        voucher.setUpdated_date(new Date());
        voucherServiceImpl.updateVoucher(voucher);
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("delete",new Voucher());
        return "main/tables/tk";
    }

    @PostMapping("delete/{id}")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        voucherServiceImpl.deleteVoucher(id);
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("delete",new Voucher());
        return "main/tables/tk";

    }
}
