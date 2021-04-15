package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.TrashcanServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/trashcon")
public class AdminTrashconController {
    @Autowired
    private TrashcanServiceImpl trashconServiceImpl;

    // api trả về danh sách user đã xóa
    @GetMapping("/user")
    @ResponseBody
    public List<User> Userdelete(){
        List<User> user = trashconServiceImpl.getUserdeleteList();
        return user;
    }

    // api trả về dnah sách sản phẩm đã xóa
    @GetMapping("/product")
    @ResponseBody
    public List<Product> Productdelete(){
        List<Product> product = trashconServiceImpl.getProductdeleteList();
        return product;
    }

    // api trả về danh sách voucher đã xóa hoặc đã hết hạn
    @GetMapping("/voucher")
    @ResponseBody
    public List<Voucher> voicherdelete(){
        List<Voucher> voucher = trashconServiceImpl.getVoucherdeleteList();
        return voucher;
    }

    //api trả về danh sách nhà cung cấp đã xóa
    @GetMapping("/supplier")
    @ResponseBody
    public List<Supplier> Supplierdelete(){
        List<Supplier> supplier = trashconServiceImpl.getSupplierdeleteList();
        return supplier;
    }

    // api trả về danh sách admin đã xóa
    @GetMapping("/admin")
    @ResponseBody
    public List<Admin> Admindelete(){
        List<Admin> admin = trashconServiceImpl.getadmindeleteList();
        return admin;
    }

    //trả về trang thùng rác admin
    @GetMapping("/trashconadmin")
    public String getadmindelete(ModelMap model){
        model.addAttribute("restor",new Admin());
        return "main/tables/tk_restore";
    }

    // cập nhật trạng thái admin từ đã xóa thành chưa xóa
    @PostMapping("/trashconadmin")
    public String restoreadmindelete(ModelMap model, @ModelAttribute  Admin admin){
        trashconServiceImpl.restoreAdmin(admin.getID());
        System.out.println("ok");
        model.addAttribute("restor",new Admin());
        return "main/tables/tk_restore";
    }

    // trả về thùng rác user
    @GetMapping("/trashconuser")
    public String restoreuserdelete(ModelMap model){
        model.addAttribute("restor", new User());
        return "main/tables/user_restore";
    }

    // cập nhật trạng thái user từ trạng thái đã xóa sang trạng thái chưa xóa
    @PostMapping("/trashconuser")
    public String restoreauserdelete(ModelMap model, @ModelAttribute  User user){
        trashconServiceImpl.restoreUser(user.getId());
        System.out.println("ok");
        model.addAttribute("restor",new User());
        return "main/tables/user_restore";
    }

    //trả về trang thùng rác nhà cung cấp
    @GetMapping("/trashconsupplier")
    public String restoresupplierdelete(ModelMap model){
        model.addAttribute("restor", new Supplier());
        return "main/tables/nhacungcap_restore";
    }

    //cập nhật trạng thái nhà cung cấp từ đã xóa thành chưa xóa
    @PostMapping("/trashconsupplier")
    public String restoreasupplierdelete(ModelMap model, @ModelAttribute  Supplier supplier){
        trashconServiceImpl.restoreSupplier(supplier.getId());
        System.out.println("ok");
        model.addAttribute("restor",new Supplier());
        return "main/tables/nhacungcap_restore";
    }

    //trả về trang thùng rá voucher
    @GetMapping("/trashconvoucher")
    public String restorevoucherdelete(ModelMap model){
        model.addAttribute("restor", new Voucher());
        return "main/tables/voucher_restore";
    }

    //cập nhật voucher từ trạng thái đã xóa(đã sử sụng) thành chưa sử dụng(chưa xóa)
    @PostMapping("/trashconvoucher")
    public String restoreavoucherdelete(ModelMap model, @ModelAttribute  Voucher voucher){
        trashconServiceImpl.restoreVoucher(voucher.getID());
        System.out.println("ok");
        model.addAttribute("restor",new Voucher());
        return "main/tables/voucher_restore";
    }

    //trả về trang thùng rác sản phẩm
    @GetMapping("/trashconproduct")
    public String restoreproductdelete(ModelMap model){
        model.addAttribute("restor", new Product());
        return "main/tables/product_restore";
    }

    //cập nhật trang thái sản phẩm từ đã xóa thành chưa xóa
    @PostMapping("/trashconproduct")
    public String restoreaproductdelete(ModelMap model, @ModelAttribute  Product product){
        trashconServiceImpl.restoreProduct(product.getID());
        System.out.println("ok");
        model.addAttribute("restor",new Product());
        return "main/tables/product_restore";
    }
}
