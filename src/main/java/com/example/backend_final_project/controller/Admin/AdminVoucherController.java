package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.Voucher;
import com.example.backend_final_project.service.Impl.VoucherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("admin/voucher")
public class AdminVoucherController {
    @Autowired
    private VoucherServiceImpl voucherServiceImpl;

    @GetMapping("/home")
    public String Home(ModelMap model){
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("message","");
        return "main/tables/voucher";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Voucher> getAdmin(){
        List<Voucher> ds = voucherServiceImpl.getVoucherList();
        return ds;
    }

    @PostMapping("/insert")
    public String InsertAdmin(ModelMap model, @ModelAttribute Voucher voucher){
        List<Voucher> vou = voucherServiceImpl.getVoucherByCode(voucher.getCode());
        if (vou.size() != 0){
            model.addAttribute("message","Mã Voucher đã tồn tại");
        }else{
            voucher.setCreated_date(new Date());
            voucherServiceImpl.addVoucher(voucher);
            model.addAttribute("message","");
        }
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());

        return "main/tables/voucher";
    }

    @PostMapping("/update")
    public String UpdateAdmin(ModelMap model, @ModelAttribute Voucher voucher){
        Voucher vou = voucherServiceImpl.getVoucherById(voucher.getID());
        if(vou.getCode() == voucher.getCode()){
            voucher.setUpdated_date(new Date());
            voucherServiceImpl.updateVoucher(voucher);
            model.addAttribute("message","");
        }else{
            List<Voucher> vou1 = voucherServiceImpl.getVoucherByCode(voucher.getCode());
            if(vou1.size() != 0){
                model.addAttribute("message","Mã Voucher đã tồn tại");
            }else{
                voucher.setUpdated_date(new Date());
                voucherServiceImpl.updateVoucher(voucher);
                model.addAttribute("message","");
            }
        }
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());

        return "main/tables/voucher";
    }

    @GetMapping("delete")
    public String Delete(ModelMap model,@RequestParam("id") int id){
        Voucher voucher = voucherServiceImpl.getVoucherById(id);
        voucher.setUpdated_date(new Date());
        voucher.setStatus(true);
        voucherServiceImpl.updateVoucher(voucher);
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("message","");
        return "main/tables/voucher";

    }
}
