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

    @GetMapping("/user")
    @ResponseBody
    public List<User> Userdelete(){
        List<User> user = trashconServiceImpl.getUserdeleteList();
        return user;
    }

    @GetMapping("/product")
    @ResponseBody
    public List<Product> Productdelete(){
        List<Product> product = trashconServiceImpl.getProductdeleteList();
        return product;
    }
    @GetMapping("/voucher")
    @ResponseBody
    public List<Voucher> voicherdelete(){
        List<Voucher> voucher = trashconServiceImpl.getVoucherdeleteList();
        return voucher;
    }

    @GetMapping("/supplier")
    @ResponseBody
    public List<Supplier> Supplierdelete(){
        List<Supplier> supplier = trashconServiceImpl.getSupplierdeleteList();
        return supplier;
    }
    @GetMapping("/admin")
    @ResponseBody
    public List<Admin> Admindelete(){
        List<Admin> admin = trashconServiceImpl.getadmindeleteList();
        return admin;
    }

    @GetMapping("/trashconadmin")
    public String getadmindelete(ModelMap model){
        model.addAttribute("restor",new Admin());
        return "main/tables/tk_restore";
    }


    @PostMapping("/trashconadmin")
    public String restoreadmindelete(ModelMap model, @ModelAttribute  Admin admin){
        trashconServiceImpl.restoreAdmin(admin.getID());
        System.out.println("ok");
        model.addAttribute("restor",new Admin());
        return "main/tables/tk_restore";
    }

    @GetMapping("/trashconuser")
    public String restoreuserdelete(ModelMap model){
        model.addAttribute("restor", new User());
        return "main/tables/user_restore";
    }

    @PostMapping("/trashconuser")
    public String restoreauserdelete(ModelMap model, @ModelAttribute  User user){
        trashconServiceImpl.restoreUser(user.getId());
        System.out.println("ok");
        model.addAttribute("restor",new User());
        return "main/tables/user_restore";
    }
    @GetMapping("/trashconsupplier")
    public String restoresupplierdelete(ModelMap model){
        model.addAttribute("restor", new Supplier());
        return "main/tables/nhacungcap_restore";
    }

    @PostMapping("/trashconsupplier")
    public String restoreasupplierdelete(ModelMap model, @ModelAttribute  Supplier supplier){
        trashconServiceImpl.restoreSupplier(supplier.getId());
        System.out.println("ok");
        model.addAttribute("restor",new Supplier());
        return "main/tables/nhacungcap_restore";
    }
    @GetMapping("/trashconvoucher")
    public String restorevoucherdelete(ModelMap model){
        model.addAttribute("restor", new Voucher());
        return "main/tables/voucher_restore";
    }

    @PostMapping("/trashconvoucher")
    public String restoreavoucherdelete(ModelMap model, @ModelAttribute  Voucher voucher){
        trashconServiceImpl.restoreVoucher(voucher.getID());
        System.out.println("ok");
        model.addAttribute("restor",new Voucher());
        return "main/tables/voucher_restore";
    }

    @GetMapping("/trashconproduct")
    public String restoreproductdelete(ModelMap model){
        model.addAttribute("restor", new Product());
        return "main/tables/product_restore";
    }

    @PostMapping("/trashconproduct")
    public String restoreaproductdelete(ModelMap model, @ModelAttribute  Product product){
        trashconServiceImpl.restoreProduct(product.getID());
        System.out.println("ok");
        model.addAttribute("restor",new Product());
        return "main/tables/product_restore";
    }
}
