package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.*;
import com.example.backend_final_project.service.dto.ProductRequest;
import com.example.backend_final_project.service.dto.Product_Property_DetailRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"username", "role"})
@RequestMapping("admin/product")
public class AdminProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @Autowired
    private SupplierServiceImpl supplierServiceImpl;

    @Autowired
    private ProductPropertyDetailServiceImpl productPropertyDetailServiceImpl;

    @Autowired
    private ProductPropertyServiceImpl productPropertyServiceImpl;

    @Autowired
    private ProductImageServiceImpl productImageServiceImpl;

    @ModelAttribute
    public void attribute(ModelMap model){
        model.addAttribute("insert", new ProductRequest());
        model.addAttribute("update", new ProductRequest());
//        model.addAttribute("delete", new ProductRespone());
        model.addAttribute("insertProperty", new Product_Property_DetailRequest());
        model.addAttribute("updateProperty", new Product_Property_DetailRequest());
//        model.addAttribute("deleteProperty", new Product_Property_DetailRespone());
        model.addAttribute("insertProductimage", new Product_Image());
        model.addAttribute("updateProductimage", new Product_Image());
    }

    //product
    @GetMapping("/list")
    @ResponseBody
    public List<Product> getproduct(){
        List<Product> product = productServiceImpl.getProductList();
        return product;
    }


    @GetMapping("/home")
    public String home(ModelMap model){
        attribute(model);
        return "main/tables/sp_test";
    }
    @GetMapping("/insert")
    public String insert(ModelMap model){
        attribute(model);
        return "main/tables/sp_test";
    }
    @GetMapping("/update")
    public String update(ModelMap model){
        attribute(model);
        return "main/tables/sp_test";
    }
    @GetMapping("/delete")
    public String delete(ModelMap model){
        attribute(model);
        return "main/tables/sp_test";
    }
    @PostMapping("/insert")
    public String insertProduct(ModelMap model, @ModelAttribute ProductRequest productRequest){
        Supplier supplier = supplierServiceImpl.getSupplierById(Integer.parseInt(productRequest.getSupplier_id()));
        Product product = new Product();

        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setIssale(productRequest.isIssale());
        product.setPrice_sale(productRequest.getPrice_sale());
        product.setDescription(productRequest.getDescription());
        product.setGender(productRequest.isGender());
        product.setQuantity(productRequest.getQuantity());
        product.setSupplier_id(supplier);
        product.setCreated_date(new Date());
        productServiceImpl.addProduct(product);
        attribute(model);
//        return "main/tables/sp_test";
        return "redirect:/admin/product/home";
    }
    @PostMapping("/update")
    public String UpdateProduct(ModelMap model,@ModelAttribute ProductRequest productRequest){
        Supplier supplier = supplierServiceImpl.getSupplierById(Integer.parseInt(productRequest.getSupplier_id()));

        Product product = new Product();
        product.setID(productRequest.getId());
        product.setCode(productRequest.getCode());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        product.setIssale(productRequest.isIssale());
        product.setPrice_sale(productRequest.getPrice_sale());
        product.setDescription(productRequest.getDescription());
        product.setGender(productRequest.isGender());
        product.setQuantity(productRequest.getQuantity());
        product.setSupplier_id(supplier);
        product.setCreated_date(productRequest.getCreated_date());

        productServiceImpl.updateProduct(product);
        attribute(model);
//        return "main/tables/sp_test";
        return "redirect:/admin/product/home";
    }
    @PostMapping("/delete")
    public String deleteProduct(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = productServiceImpl.deleteProduct(id_delete);
        if(ketqua == true){

        }else{
            Product product = productServiceImpl.getProductById(id_delete);
            product.setIsdelete(true);
            productServiceImpl.updateProduct(product);
        }
        attribute(model);
//        return "main/tables/sp_test";
        return "redirect:/admin/product/home";
    }

    //product_property_detail
    @GetMapping("productPropertydetail/list/{id}")
    @ResponseBody
    public List<Product_Property_Detail> getPropertydetail(@PathVariable("id") int id){
        List<Product_Property_Detail> list = productPropertyDetailServiceImpl.getByProductId(id);
        return list;
    }


    @GetMapping("/property/home/{id_product}")
    public String getPropertyid(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
    }
    @GetMapping("/property/insert/{id_product}")
    public String Propertyinsertreloat(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
    }

    @GetMapping("/property/update/{id_product}")
    public String Propertydupdatereloat(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
    }
    @GetMapping("/property/delete/{id_product}")
    public String Propertyddeletereloat(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
    }
    @PostMapping("/property/insert/{id_product}")
    public String insertPropertyid(ModelMap model, @PathVariable("id_product") int id_product,@ModelAttribute Product_Property_DetailRequest product_property_detailRequest){
        Product product = productServiceImpl.getProductById(id_product);
        Product_Property product_property = productPropertyServiceImpl.getProductPropertyById(Integer.parseInt(product_property_detailRequest.getId_property()));
        Product_Property_Detail product_property_detail = new Product_Property_Detail();
        product_property_detail.setProduct(product);
        product_property_detail.setProduct_Property(product_property);
        product_property_detail.setDescription(product_property_detailRequest.getDescription());
        product_property_detail.setCreated_date(new Date());
        productPropertyDetailServiceImpl.addProductPropertyD(product_property_detail);
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_property";
        return "redirect:/admin/product/property/home/"+id_product;
    }
    @PostMapping("/property/update/{id_product}")
    public String updatePropertyid(ModelMap model, @PathVariable("id_product") int id_product,@ModelAttribute Product_Property_DetailRequest product_property_detailRequest){
        Product product = productServiceImpl.getProductById(id_product);
        Product_Property product_property = productPropertyServiceImpl.getProductPropertyById(Integer.parseInt(product_property_detailRequest.getId_property()));
        Product_Property_Detail product_property_detail = new Product_Property_Detail();
        product_property_detail.setProduct(product);
        product_property_detail.setProduct_Property(product_property);
        product_property_detail.setDescription(product_property_detailRequest.getDescription());
        product_property_detail.setCreated_date(product_property_detailRequest.getCreated_date());
        product_property_detail.setUpdated_date(new Date());
        product_property_detail.setID(product_property_detailRequest.getId());
        productPropertyDetailServiceImpl.updateProductPropertyD(product_property_detail);
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_property";
        return "redirect:/admin/product/property/home/"+id_product;
    }
    @PostMapping("/property/delete/{id_product}")
    public String deletePropertyid(ModelMap model, @PathVariable("id_product") int id_product,@RequestParam("id_delete") int id_delete){

        productPropertyDetailServiceImpl.deleteProductPropertyD(id_delete);
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_property";
        return "redirect:/admin/product/property/home/"+id_product;
    }
    //product_image

    @GetMapping("productimage/list/{id}")
    @ResponseBody
    public List<Product_Image> getProduct_image(@PathVariable("id") int id){
        List<Product_Image> list = productImageServiceImpl.getProductImageByProdId(id);
        return list;
    }
    @GetMapping("/image/home/{id_product}")
    public String getimageid(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
    }
    @GetMapping("/image/insert/{id_product}")
    public String imageinser(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
    }
    @GetMapping("/image/update/{id_product}")
    public String imageupdate(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
    }
    @GetMapping("/image/delete/{id_product}")
    public String imagedelete(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
    }



    @PostMapping("/image/insert/{id_product}")
    public String insertimage(ModelMap model, @PathVariable("id_product") int id_product, @ModelAttribute Product_Image product_image, @RequestPart("file") MultipartFile file){
        System.out.println(file.toString());
        System.out.println(file.getOriginalFilename());
//            String path = "./hinhanh";
        String path = System.getProperty("user.dir")+"/hinhanh/";
        String filename= file.getOriginalFilename();
        System.out.println(path);
        try{
            Date time = new Date();
            String image_name = id_product+"_"+"anh"+"_"+time.getTime()+filename;
            byte barr[]=file.getBytes();

            BufferedOutputStream bout=new BufferedOutputStream(
                    new FileOutputStream(path+"/"+image_name));
            bout.write(barr);
            bout.flush();
            bout.close();
            Product product = productServiceImpl.getProductById(id_product);
            product_image.setCreated_date(new Date());
            product_image.setImage(image_name);
            product_image.setProduct(product);
            productImageServiceImpl.addProductImage(product_image);

        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("aaaaa");
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_image";
        return "redirect:/admin/product/image/home/"+id_product;
    }

    @PostMapping("image/update/{id_product}")
    public String updateimage(ModelMap model, @PathVariable("id_product") int id_product, @ModelAttribute Product_Image product_image, @RequestPart("file") MultipartFile file){

        if(file.getSize() != 0){
            //            String path = "./hinhanh";
            String path = System.getProperty("user.dir")+"/hinhanh/";

            String filename= file.getOriginalFilename();
            try{
                Date time = new Date();
                String image_name = id_product+"_"+"anh"+"_"+time.getTime()+filename;
                byte barr[]=file.getBytes();

                BufferedOutputStream bout=new BufferedOutputStream(
                        new FileOutputStream(path+"/"+image_name));
                bout.write(barr);
                bout.flush();
                bout.close();
                Product product = productServiceImpl.getProductById(id_product);
                product_image.setUpdated_date(new Date());
                product_image.setImage(image_name);
                product_image.setProduct(product);
                productImageServiceImpl.updateProductImage(product_image);

            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            Product product = productServiceImpl.getProductById(id_product);
            product_image.setProduct(product);
            product_image.setUpdated_date(new Date());
            productImageServiceImpl.updateProductImage(product_image);
        }
        getProduct_image(id_product);
//        File dir = new File(System.getProperty("user.dir")+"/src/main/resources/static/assets/hinhanh");
//        System.out.println(dir);
//        System.out.println("aaaaaaa");
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_image";
        return "redirect:/admin/product/image/home/"+id_product;
    }
    @PostMapping("/image/delete/{id_product}")
    public String deleteimage(ModelMap model, @PathVariable("id_product") int id_product,@RequestParam int id_delete){
        productImageServiceImpl.deleteProductImage(id_delete);
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_image";
        return "redirect:/admin/product/image/home/"+id_product;
    }

}
