//package com.example.backend_final_project.controller.Admin;
//
//import com.example.backend_final_project.model.Product;
//import com.example.backend_final_project.model.Supplier;
//import com.example.backend_final_project.service.Impl.ProductServiceImpl;
//import com.example.backend_final_project.service.Impl.SupplierServiceImpl;
//import com.example.backend_final_project.service.dto.StorageRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.ParseException;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//@RequestMapping("admin/storage")
//public class AdminStorageController {
//
//    @Autowired
//    private ProductServiceImpl productServiceImpl;
//
//    @Autowired
//    private SupplierServiceImpl supplierServiceImpl;
//
//
//
//    @GetMapping("/home")
//    public String Home(ModelMap model){
//        model.addAttribute("insert",new StorageRequest());
//        model.addAttribute("update",new StorageRequest());
//        model.addAttribute("message","");
//        return "main/tables/kho";
//    }
//
//    @GetMapping("/list")
//    @ResponseBody
//    public List<Product> getAdmin(){
//        List<Product> ds = productServiceImpl.getProductList();
//        return ds;
//    }
//
//    @PostMapping("/insert")
//    public String InsertAdmin(ModelMap model, @ModelAttribute StorageRequest storageRequest){
//        int id_product = Integer.parseInt(storageRequest.getId_product());
//        int id_supplier = Integer.parseInt(storageRequest.getId_supplier());
//        Product product = productServiceImpl.getProductById(id_product);
//        Supplier supplier = providerServiceImpl.getProviderById(id_supplier);
//        List<Storage> storage = storageServiceImpl.getStorageByProdID(id_product);
//        if(storage.size() != 0){
//            model.addAttribute("message","Insert thất bại \n 1 Sản Phẩm Chỉ Được cung cấp từ 1 nhà Cung Cấp");
//            System.out.println("aaaaaaaaaaa");
//        }else{
//            Storage storage1 = new Storage();
//            storage1.setProvider(supplier);
//            storage1.setProduct(product);
//            storage1.setQuantity(storageRequest.getQuantity());
//            storage1.setCreated_date(new Date());
//            storageServiceImpl.addStorage(storage1);
//            model.addAttribute("message","");
//        }
//        model.addAttribute("insert", new StorageRequest());
//        model.addAttribute("update", new StorageRequest());
//
//
//        return "main/tables/kho";
//    }
//
//    @PostMapping("/update")
//    public String UpdateAdmin(ModelMap model, @ModelAttribute StorageRequest storageRequest) throws ParseException {
//        Storage storage = storageServiceImpl.getStorageById(storageRequest.getId());
//        int id_product = Integer.parseInt(storageRequest.getId_product());
//        int id_provider = Integer.parseInt(storageRequest.getId_provider());
//        if(storage.getProduct().getID() == id_product && storage.getProvider().getId() == id_provider){
//            storage.setQuantity(storageRequest.getQuantity());
//            storage.setUpdated_date(new Date());
//            storageServiceImpl.updateStorage(storage);
//            model.addAttribute("message","");
//            System.out.println("aaa");
//        }else{
//            Product product = productServiceImpl.getProductById(id_product);
//            Supplier supplier = providerServiceImpl.getProviderById(id_provider);
//            if(storage.getProduct().getID() != id_product){
//                List<Storage> storage1 = storageServiceImpl.getStorageByProdID(id_product);
//                if(storage1.size() != 0){
//                    model.addAttribute("message","Update thất bại \n 1 Sản Phẩm Chỉ Được cung cấp từ 1 nhà Cung Cấp");
//                    System.out.println("bbb");
//                }else{
//                    storage.setProduct(product);
//                    storage.setProvider(supplier);
//                    storage.setQuantity(storageRequest.getQuantity());
//                    storage.setUpdated_date(new Date());
//                    storageServiceImpl.updateStorage(storage);
//                    model.addAttribute("message","");
//                    System.out.println("ccc");
//                }
//
//            }else{
//                storage.setProduct(product);
//                storage.setProvider(supplier);
//                storage.setQuantity(storageRequest.getQuantity());
//                storage.setUpdated_date(new Date());
//                storageServiceImpl.updateStorage(storage);
//                model.addAttribute("message","");
//                System.out.println("ddd");
//            }
//        }
//
//        model.addAttribute("insert",new StorageRequest());
//        model.addAttribute("update",new StorageRequest());
//
//
//        return "main/tables/kho";
//    }
//
//    @GetMapping("delete")
//    public String Delete(ModelMap model,@RequestParam("id") int id){
//        storageServiceImpl.deleteStorage(id);
//        model.addAttribute("insert",new StorageRequest());
//        model.addAttribute("update",new StorageRequest());
//        model.addAttribute("message","");
//
//        return "main/tables/kho";
//
//    }
//}
