package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.ImageUtil;

import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.service.Impl.ProductImageServiceImpl;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/image")
public class DownloadImageREST {
    @Autowired
    private ProductImageServiceImpl productImageService;

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("/getImages/{productID}/{pos}")
    public ResponseEntity<byte[]> downloadImage (@PathVariable int productID, @PathVariable int pos, HttpServletResponse resp){
        List<Product_Image> prodImg = productImageService.getProductImagesByProdId(productID);
        resp.setHeader("Content-Disposition","attachment;filename="+ prodImg.get(pos).getImage());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(ImageUtil.open(prodImg.get(pos).getImage()));
    }

    @GetMapping("/getIndexImages/{productID}")
    public ResponseEntity<byte[]> downloadIndexImage (@PathVariable int productID, HttpServletResponse resp){
        List<Product_Image> prodImg = productImageService.getProductImagesIndexByProdId(productID);
        resp.setHeader("Content-Disposition","attachment;filename="+ prodImg.get(0).getImage());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(ImageUtil.open(prodImg.get(0).getImage()));
    }

    @GetMapping("/getImagesByID/{productimageID}")
    public ResponseEntity<byte[]> downloadImageByID (@PathVariable int productimageID, HttpServletResponse resp){
        Product_Image prodImg = productImageService.getProductImageById(productimageID);
        resp.setHeader("Content-Disposition","attachment;filename="+ prodImg.getImage());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(ImageUtil.open(prodImg.getImage()));
    }

    @GetMapping("/getImagesCount/{productID}")
    public ResponseEntity<?> getImageCount (@PathVariable int productID, HttpServletRequest req){
        List<Product_Image> prodImg = productImageService.getProductImagesByProdId(productID);
        return ResponseEntity.ok(prodImg.size());
    }
}
