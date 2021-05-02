package com.example.backend_final_project.controller.Admin;


import com.example.backend_final_project.model.Voucher;
import com.example.backend_final_project.service.Impl.VoucherServiceImpl;
import com.example.backend_final_project.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/voucher")
public class AdminVoucherController {
    @Autowired
    private VoucherServiceImpl voucherServiceImpl;

    @ModelAttribute
    public void attribute(ModelMap model){
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
    }

    //trả về trang quản lý voucher
    @GetMapping("/home")
    public String Home(ModelMap model){
//        model.addAttribute("insert",new Voucher());
//        model.addAttribute("update",new Voucher());
        attribute(model);
        model.addAttribute("message","");
        return "main/tables/voucher";
    }

    // api lấy danh sách voucher có trong db với trạng thái chưa xóa(chưa sử dụng)
    @GetMapping("/list")
    @ResponseBody
    public List<Voucher> getVoucher(){
        List<Voucher> ds = voucherServiceImpl.getVoucherList();
        return ds;
    }


    //trả về trang quản lý voucher
    @GetMapping("/update")
    public String update(ModelMap model){
        model.addAttribute("insert",new Voucher());
        model.addAttribute("update",new Voucher());
        model.addAttribute("message","");
        return "main/tables/voucher";
    }


    //thêm voucher vào db
    @PostMapping("/insert")
    public String InsertVoucher(ModelMap model, @ModelAttribute Voucher voucher){
        List<Voucher> vou = voucherServiceImpl.getVoucherByCode(voucher.getCode());
        //kiểm tra mã voucher đã tồn tại chưa
        if (vou.size() != 0){
            model.addAttribute("message","Mã Voucher đã tồn tại");
            attribute(model);
            return "main/tables/voucher";
        }else{
            voucher.setCreated_date(new Date());
            voucher.setCreated_by(SessionService.username);
            voucherServiceImpl.addVoucher(voucher);
            model.addAttribute("message","");
            attribute(model);
            return "redirect:/admin/voucher/home";
        }

    }

    //cập nhật voucher
    @PostMapping("/update")
    public String UpdateVoucher(ModelMap model, @ModelAttribute Voucher voucher){
        Voucher vou = voucherServiceImpl.getVoucherById(voucher.getID());
        // kiểm tra mã voucher có bị thay đổi không
        if(vou.getCode().equals(voucher.getCode())){
            voucher.setUpdated_date(new Date());
            voucher.setUpdated_by(SessionService.username);
            voucherServiceImpl.updateVoucher(voucher);
            model.addAttribute("message","");
            attribute(model);
            return "redirect:/admin/voucher/home";
        }else{
            List<Voucher> vou1 = voucherServiceImpl.getVoucherByCode(voucher.getCode());
            //kiểm tra mã voucher đã tồn tại chưa
            if(vou1.size() != 0){
                model.addAttribute("message","Mã Voucher đã tồn tại");
                attribute(model);
                return "main/tables/voucher";
            }else{
                voucher.setUpdated_date(new Date());
                voucher.setUpdated_by(SessionService.username);
                voucherServiceImpl.updateVoucher(voucher);
                model.addAttribute("message","");
                attribute(model);
                return "redirect:/admin/voucher/home";
            }
        }

    }

    //xóa voucher
    @PostMapping("delete")
    public String DeleteVoucher(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = voucherServiceImpl.deleteVoucher(id_delete);
        if(ketqua == true){

        }else {
            Voucher voucher = voucherServiceImpl.getVoucherById(id_delete);
            voucher.setUpdated_date(new Date());
            voucher.setStatus(true);
            voucher.setUpdated_by(SessionService.username);
            voucherServiceImpl.updateVoucher(voucher);
        }

        attribute(model);
        model.addAttribute("message","");
        return "redirect:/admin/voucher/home";

    }
}
