package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.model.*;
import com.example.backend_final_project.service.Impl.*;
import com.example.backend_final_project.service.SessionService;
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

    //api lấy danh sách sản phẩm có trang thái chưa xóa có trong db
    @GetMapping("/list")
    @ResponseBody
    public List<Product> getproduct(){
        List<Product> product = productServiceImpl.getProductList();
        return product;
    }

    // trả về trang quản lý sản phâm
    @GetMapping("/home")
    public String home(ModelMap model){
        attribute(model);
        return "main/tables/sanpham";
    }
    //    @GetMapping("/insert")
//    public String insert(ModelMap model){
//        attribute(model);
//        return "main/tables/sp_test";
//    }
//    @GetMapping("/update")
//    public String update(ModelMap model){
//        attribute(model);
//        return "main/tables/sp_test";
//    }
//    @GetMapping("/delete")
//    public String delete(ModelMap model){
//        attribute(model);
//        return "main/tables/sp_test";
//    }

    //thêm sản phẩm mới
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
        product.setCreated_by(SessionService.username);
        productServiceImpl.addProduct(product);
        attribute(model);
//        return "main/tables/sp_test";
        return "redirect:/admin/product/home";
    }

    //cập nhật sản phẩm
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
        product.setCreated_by(productRequest.getCreated_by());
        product.setUpdated_date(new Date());
        product.setUpdated_by(SessionService.username);
        productServiceImpl.updateProduct(product);
        attribute(model);
//        return "main/tables/sp_test";
        return "redirect:/admin/product/home";
    }

    //xóa sản phẩm
    @PostMapping("/delete")
    public String deleteProduct(ModelMap model,@RequestParam("id_delete") int id_delete){
        boolean ketqua = productServiceImpl.deleteProduct(id_delete);
        if(ketqua == true){

        }else{
            // nếu xóa thất bại thì chuyển trạng thái của sản phẩm từ chưa xóa sang đã xóa
            Product product = productServiceImpl.getProductById(id_delete);
            product.setIsdelete(true);
            product.setUpdated_date(new Date());
            product.setUpdated_by(SessionService.username);
            productServiceImpl.updateProduct(product);
        }
        attribute(model);
//        return "main/tables/sp_test";
        return "redirect:/admin/product/home";
    }

    //product_property_detail
    // api lấy danh sách thuộc tính chi tiết sản phẩm theo id
    @GetMapping("productPropertydetail/list/{id}")
    @ResponseBody
    public List<Product_Property_Detail> getPropertydetail(@PathVariable("id") int id){
        List<Product_Property_Detail> list = productPropertyDetailServiceImpl.getByProductId(id);
        return list;
    }

    // trả về trang quản lý thuộc tính sản phẩm có product id tương ứng
    @GetMapping("/property/home/{id_product}")
    public String getPropertyid(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
    }
    //    @GetMapping("/property/insert/{id_product}")
//    public String Propertyinsertreloat(ModelMap model, @PathVariable("id_product") int id_product){
//        model.addAttribute("id", id_product);
//        attribute(model);
//        return "main/tables/sp_property";
//    }
//
    @GetMapping("/property/update/{id_product}")
    public String Propertydupdatereloat(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
    }
//    @GetMapping("/property/delete/{id_product}")
//    public String Propertyddeletereloat(ModelMap model, @PathVariable("id_product") int id_product){
//        model.addAttribute("id", id_product);
//        attribute(model);
//        return "main/tables/sp_property";
//    }

    // thêm thuộc tính sản phẩm mới vào db
    @PostMapping("/property/home/{id_product}")
    public String insertPropertyid(ModelMap model, @PathVariable("id_product") int id_product,@ModelAttribute Product_Property_DetailRequest product_property_detailRequest){
        List<Product_Property_Detail> listproperty = productPropertyDetailServiceImpl.getByProductIdAndPropertyRoot(id_product,Integer.parseInt(product_property_detailRequest.getId_property()));
        if(listproperty.size() > 0){
            model.addAttribute("message","Thuộc tính đã tồn tại");
        }else {
            Product product = productServiceImpl.getProductById(id_product);
            Product_Property product_property = productPropertyServiceImpl.getProductPropertyById(Integer.parseInt(product_property_detailRequest.getId_property()));
            Product_Property_Detail product_property_detail = new Product_Property_Detail();
            product_property_detail.setProduct(product);
            product_property_detail.setProduct_Property(product_property);
            product_property_detail.setDescription(product_property_detailRequest.getDescription());
            product_property_detail.setCreated_date(new Date());
            product_property_detail.setCreated_by(SessionService.username);
            productPropertyDetailServiceImpl.addProductPropertyD(product_property_detail);
        }
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_property";
//        return "redirect:/admin/product/property/home/"+id_product;
    }

    //cập nhật thuộc tính sản phẩm
    @PostMapping("/property/update/{id_product}")
    public String updatePropertyid(ModelMap model, @PathVariable("id_product") int id_product,@ModelAttribute Product_Property_DetailRequest product_property_detailRequest){
        Product_Property_Detail property_detail = productPropertyDetailServiceImpl.getProductPropertyDetailById (product_property_detailRequest.getId());

        if(property_detail.getProduct_Property().getID() != Integer.parseInt(product_property_detailRequest.getId_property())){

            List<Product_Property_Detail> listproperty = productPropertyDetailServiceImpl.getByProductIdAndPropertyRoot(id_product,Integer.parseInt(product_property_detailRequest.getId_property()));
            if(listproperty.size() >0){
                model.addAttribute("message","Thuộc tính đã tồn tại");
                model.addAttribute("id", id_product);
                attribute(model);
                return "main/tables/sp_property";
            }else{
                Product product = productServiceImpl.getProductById(id_product);
                Product_Property product_property = productPropertyServiceImpl.getProductPropertyById(Integer.parseInt(product_property_detailRequest.getId_property()));
                Product_Property_Detail product_property_detail = new Product_Property_Detail();
                product_property_detail.setProduct(product);
                product_property_detail.setProduct_Property(product_property);
                product_property_detail.setDescription(product_property_detailRequest.getDescription());
                product_property_detail.setCreated_date(product_property_detailRequest.getCreated_date());
                product_property_detail.setCreated_by(product_property_detailRequest.getCreated_by());
                product_property_detail.setUpdated_date(new Date());
                product_property_detail.setUpdated_by(SessionService.username);
                product_property_detail.setID(product_property_detailRequest.getId());
                productPropertyDetailServiceImpl.updateProductPropertyD(product_property_detail);
                model.addAttribute("id", id_product);
                attribute(model);
                return "redirect:/admin/product/property/home/"+id_product;
            }
        }else {

            Product product = productServiceImpl.getProductById(id_product);
            Product_Property product_property = productPropertyServiceImpl.getProductPropertyById(Integer.parseInt(product_property_detailRequest.getId_property()));
            Product_Property_Detail product_property_detail = new Product_Property_Detail();
            product_property_detail.setProduct(product);
            product_property_detail.setProduct_Property(product_property);
            product_property_detail.setDescription(product_property_detailRequest.getDescription());
            product_property_detail.setCreated_date(product_property_detailRequest.getCreated_date());
            product_property_detail.setCreated_by(product_property_detailRequest.getCreated_by());
            product_property_detail.setUpdated_date(new Date());
            product_property_detail.setUpdated_by(SessionService.username);
            product_property_detail.setID(product_property_detailRequest.getId());
            productPropertyDetailServiceImpl.updateProductPropertyD(product_property_detail);
            model.addAttribute("id", id_product);
            attribute(model);
            return "redirect:/admin/product/property/home/"+id_product;
        }
//        model.addAttribute("id", id_product);
//        attribute(model);
////        return "main/tables/sp_property";
//        return "redirect:/admin/product/property/home/"+id_product;
    }

    // xóa thuộc tính sản phẩm
    @PostMapping("/property/delete/{id_product}")
    public String deletePropertyid(ModelMap model, @PathVariable("id_product") int id_product,@RequestParam("id_delete") int id_delete){

        productPropertyDetailServiceImpl.deleteProductPropertyD(id_delete);
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_property";
        return "redirect:/admin/product/property/home/"+id_product;
    }
    //product_image
// api lấy danh sách product_image theo product id
    @GetMapping("productimage/list/{id}")
    @ResponseBody
    public List<Product_Image> getProduct_image(@PathVariable("id") int id){
        List<Product_Image> list = productImageServiceImpl.getProductImageByProdId(id);
        return list;
    }

    //trả về trang quản lý hình ảnh sản phẩm theo product id
    @GetMapping("/image/home/{id_product}")
    public String getimageid(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
    }
    //    @GetMapping("/image/insert/{id_product}")
//    public String imageinser(ModelMap model, @PathVariable("id_product") int id_product){
//        model.addAttribute("id", id_product);
//        attribute(model);
//        return "main/tables/sp_image";
//    }
    @GetMapping("/image/update/{id_product}")
    public String imageupdate(ModelMap model, @PathVariable("id_product") int id_product){
        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
    }
//    @GetMapping("/image/delete/{id_product}")
//    public String imagedelete(ModelMap model, @PathVariable("id_product") int id_product){
//        model.addAttribute("id", id_product);
//        attribute(model);
//        return "main/tables/sp_image";
//    }


    // thêm hình ảnh mới vào db
    @PostMapping("/image/home/{id_product}")
    public String insertimage(ModelMap model, @PathVariable("id_product") int id_product, @ModelAttribute Product_Image product_image, @RequestPart("file") MultipartFile file){
        List<Product_Image> listImage = productImageServiceImpl.getProductImagesIndexByProdId(id_product);
        if(listImage.size() >=1 && product_image.getProiority() == 1){
            model.addAttribute("message","Mỗi sản phẩm chỉ có 1 hình chính");
        }else{
            List<Product_Image> listImage1 = productImageServiceImpl.getProductImagesByProdId(id_product);
            if(listImage1.size() >=4){
                model.addAttribute("message","Mỗi sản phẩm chỉ có 4 hình phụ");
            }else{

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
                    product_image.setCreated_by(SessionService.username);
                    productImageServiceImpl.addProductImage(product_image);
                    model.addAttribute("message","");
                }catch(Exception e){
                    System.out.println(e);
                }
            }
        }
//            String path = "./hinhanh";


        model.addAttribute("id", id_product);
        attribute(model);
        return "main/tables/sp_image";
//        return "redirect:/admin/product/image/home/"+id_product;
    }

    // cập nhật hình ảnh sản phẩm
    @PostMapping("image/update/{id_product}")
    public String updateimage(ModelMap model, @PathVariable("id_product") int id_product, @ModelAttribute Product_Image product_image, @RequestPart("file") MultipartFile file){
        Product_Image image = productImageServiceImpl.getProductImageById(product_image.getID());
        if(product_image.getProiority() != image.getProiority()){

            if(product_image.getProiority() == 1){
                List<Product_Image> listImage = productImageServiceImpl.getProductImagesIndexByProdId(id_product);
                if (listImage.size() >= 1){
                    model.addAttribute("message","Mõi sản phẩm chỉ có 1 hình chính");
                    model.addAttribute("id", id_product);
                    attribute(model);
                    return "main/tables/sp_image";
                }else
                {
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
                            product_image.setUpdated_by(SessionService.username);
                            productImageServiceImpl.updateProductImage(product_image);

                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }else{
                        Product product = productServiceImpl.getProductById(id_product);
                        product_image.setProduct(product);
                        product_image.setUpdated_date(new Date());
                        product_image.setUpdated_by(SessionService.username);
                        productImageServiceImpl.updateProductImage(product_image);
                    }
                    model.addAttribute("id", id_product);
                    attribute(model);
                    return "redirect:/admin/product/image/home/"+id_product;
                }
            }else{
                List<Product_Image> listImage = productImageServiceImpl.getProductImagesByProdId(id_product);
                if(listImage.size() >=4){
                    model.addAttribute("message","Mỗi sản phẩm chỉ có 4 hình phụ");
                    model.addAttribute("id", id_product);
                    attribute(model);
                    return "main/tables/sp_image";
                }else{
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
                            product_image.setUpdated_by(SessionService.username);
                            productImageServiceImpl.updateProductImage(product_image);

                        }catch(Exception e){
                            System.out.println(e);
                        }
                    }else{
                        Product product = productServiceImpl.getProductById(id_product);
                        product_image.setProduct(product);
                        product_image.setUpdated_date(new Date());
                        product_image.setUpdated_by(SessionService.username);
                        productImageServiceImpl.updateProductImage(product_image);
                    }
                    model.addAttribute("id", id_product);
                    attribute(model);
                    return "redirect:/admin/product/image/home/"+id_product;
                }
            }
        }
        else{
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
                    product_image.setUpdated_by(SessionService.username);
                    productImageServiceImpl.updateProductImage(product_image);

                }catch(Exception e){
                    System.out.println(e);
                }
            }else{
                Product product = productServiceImpl.getProductById(id_product);
                product_image.setProduct(product);
                product_image.setUpdated_date(new Date());
                product_image.setUpdated_by(SessionService.username);
                productImageServiceImpl.updateProductImage(product_image);
            }
            model.addAttribute("id", id_product);
            attribute(model);
            return "redirect:/admin/product/image/home/"+id_product;

        }
//        if(file.getSize() != 0){
//            //            String path = "./hinhanh";
//            String path = System.getProperty("user.dir")+"/hinhanh/";
//
//            String filename= file.getOriginalFilename();
//            try{
//                Date time = new Date();
//                String image_name = id_product+"_"+"anh"+"_"+time.getTime()+filename;
//                byte barr[]=file.getBytes();
//
//                BufferedOutputStream bout=new BufferedOutputStream(
//                        new FileOutputStream(path+"/"+image_name));
//                bout.write(barr);
//                bout.flush();
//                bout.close();
//                Product product = productServiceImpl.getProductById(id_product);
//                product_image.setUpdated_date(new Date());
//                product_image.setImage(image_name);
//                product_image.setProduct(product);
//                product_image.setUpdated_by(SessionService.username);
//                productImageServiceImpl.updateProductImage(product_image);
//
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        }else{
//            Product product = productServiceImpl.getProductById(id_product);
//            product_image.setProduct(product);
//            product_image.setUpdated_date(new Date());
//            product_image.setUpdated_by(SessionService.username);
//            productImageServiceImpl.updateProductImage(product_image);
//        }

//        File dir = new File(System.getProperty("user.dir")+"/src/main/resources/static/assets/hinhanh");
//        System.out.println(dir);
//        System.out.println("aaaaaaa");
//        model.addAttribute("id", id_product);
//        attribute(model);
////        return "main/tables/sp_image";
//        return "redirect:/admin/product/image/home/"+id_product;
    }

    //xóa hình ảnh sản phẩm

    @PostMapping("/image/delete/{id_product}")
    public String deleteimage(ModelMap model, @PathVariable("id_product") int id_product,@RequestParam int id_delete){
        productImageServiceImpl.deleteProductImage(id_delete);
        model.addAttribute("id", id_product);
        attribute(model);
//        return "main/tables/sp_image";
        return "redirect:/admin/product/image/home/"+id_product;
    }

}
