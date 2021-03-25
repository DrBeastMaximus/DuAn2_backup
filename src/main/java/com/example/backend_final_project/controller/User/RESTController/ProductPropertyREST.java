package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Product_Property;
import com.example.backend_final_project.model.Product_Property_Detail;
import com.example.backend_final_project.service.ProductPropertyDetailService;
import com.example.backend_final_project.service.ProductPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/product/property")
public class ProductPropertyREST {
    @Autowired
    private ProductPropertyService ppService;
    @Autowired
    private ProductPropertyDetailService ppdService;

    @GetMapping("/getProperty")
    public ResponseEntity getRoot(){
        List<Product_Property> pd = ppService.getProductPropertyList();
        Map<String, Object> obj = new LinkedHashMap<>();
        for(int i=0;i<pd.size();i++){
            obj.put("propertyRoot",pd);
            obj.put("propertyDetail",ppdService.getNameByProductPropertyId(pd.get(i).getID()));
        }



        return ResponseEntity.ok(obj);
    }

//    @GetMapping("/getBranchProperty/{rootID}")
//    public ResponseEntity getBranches(@PathVariable int rootID){
//
//        return ResponseEntity.ok(ppdService.getByProductPropertyId(rootID));
//    }
    @GetMapping("/test/{rootID}")
    public ResponseEntity test(@PathVariable int rootID){

        return ResponseEntity.ok(ppdService.getNameByProductPropertyId(rootID));
    }

    @GetMapping("/getBranchPropertyFromProductID/{prodID}")
    public ResponseEntity getBranchPropertyFromProductID(@PathVariable int prodID){
        return ResponseEntity.ok(ppdService.getByProductId(prodID));
    }
}
