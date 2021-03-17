package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.service.ProductPropertyDetailService;
import com.example.backend_final_project.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/property")
public class ProductPropertyREST {
    @Autowired
    private ProductPropertyService ppService;
    @Autowired
    private ProductPropertyDetailService ppdService;

    @GetMapping("/getRootProperty")
    public ResponseEntity getRoot(){
        return ResponseEntity.ok(ppService.getProductPropertyList());
    }

    @GetMapping("/getBranchProperty/{rootID}")
    public ResponseEntity getBranches(@PathVariable int rootID){
        return ResponseEntity.ok(ppdService.getByProductPropertyId(rootID));
    }

    @GetMapping("/getBranchPropertyFromProductID/{prodID}")
    public ResponseEntity getBranchPropertyFromProductID(@PathVariable int prodID){
        return ResponseEntity.ok(ppdService.getByProductId(prodID));
    }
}
