package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductPageREST {
    @Autowired
    private ProductServiceImpl productService;
//    @GetMapping("/{propertyids}")
//    public ResponseEntity<List<Product>> showAllProduct(@PathVariable List<Integer> propertyids){
//        List<Product> prod = new ArrayList<>();
//        for(Integer x: propertyids){
//            prod.addAll(productService.getHotMaleProductListFiltered(x));
//        }
//        return ResponseEntity.ok(prod);
//    }
    @GetMapping("/gender/male/totalRecord/{page}/{size}/{propertyids}")
    public ResponseEntity<Integer> totalMaleProdRecordsFiltered(@PathVariable Integer page,@PathVariable Integer size,@PathVariable List<Integer> propertyids){
        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotMaleProductListFiltered(x));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/totalRecord/{page}/{size}/{min}/{max}/{propertyids}")
    public ResponseEntity<Integer> totalMaleProdRecordsFilteredInRange(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max,@PathVariable List<Integer> propertyids){
        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotMaleProductListFilteredInRange(x,min,max));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/female/totalRecord/{page}/{size}/{min}/{max}/{propertyids}")
    public ResponseEntity<Integer> totalFemaleProdRecordsFilteredInRange(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max,@PathVariable List<Integer> propertyids){
        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotFemaleProductListFilteredInRange(x,min,max));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/female/totalRecord/{page}/{size}/{min}/{max}")
    public ResponseEntity<Integer> totalFemaleProdRecordsInRange(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max){
        List<Product> usn = productService.getHotFemaleProductListInRange(min,max);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/totalRecord/{page}/{size}/{min}/{max}")
    public ResponseEntity<Integer> totalMaleProdRecordsInRange(@PathVariable Integer page,@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max){
        List<Product> usn = productService.getHotMaleProductListInRange(min,max);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }

    @GetMapping("/gender/female/totalRecord/{page}/{size}/{propertyids}")
    public ResponseEntity<Integer> totalFemaleProdRecordsFiltered(@PathVariable Integer page,@PathVariable Integer size,@PathVariable List<Integer> propertyids){
        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotFemaleProductListFiltered(x));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/totalRecord/{page}/{size}")
    public ResponseEntity<Integer> totalMaleProdRecords(@PathVariable Integer page,@PathVariable Integer size){
        List<Product> usn = productService.getMaleProductList();
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/female/totalRecord/{page}/{size}")
    public ResponseEntity<Integer> totalFemaleProdRecords(@PathVariable Integer page,@PathVariable Integer size){
        List<Product> usn = productService.getFemaleProductList();
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/{page}/{size}/{sort}")
    public ResponseEntity<List<Product>> getMaleProd(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort) {

        List<Product> usn = productService.getMaleProductList();

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/male/{page}/{size}/{sort}/{min}/{max}")
    public ResponseEntity<List<Product>> getMaleProdInRange(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,
            @PathVariable Long min,
            @PathVariable Long max) {

        List<Product> usn = productService.getHotFemaleProductListInRange(min, max);

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/female/{page}/{size}/{sort}/{min}/{max}")
    public ResponseEntity<List<Product>> getFemaleProdInRange(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,
            @PathVariable Long min,
            @PathVariable Long max) {

        List<Product> usn = productService.getHotFemaleProductListInRange(min, max);

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/male/{page}/{size}/{sort}/{propertyids}")
    public ResponseEntity<List<Product>> getMaleProdFiltered(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,
            @PathVariable List<Integer> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotMaleProductListFiltered(x));

        }

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/male/{page}/{size}/{sort}/{min}/{max}/{propertyids}")
    public ResponseEntity<List<Product>> getMaleProdFilteredInRange(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,@PathVariable Long min, @PathVariable Long max,
            @PathVariable List<Integer> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotMaleProductListFilteredInRange(x,min,max));

        }

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/female/{page}/{size}/{sort}/{min}/{max}/{propertyids}")
    public ResponseEntity<List<Product>> getFemaleProdFilteredInRange(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,@PathVariable Long min, @PathVariable Long max,
            @PathVariable List<Integer> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotFemaleProductListFilteredInRange(x,min,max));

        }

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/female/{page}/{size}/{sort}/{propertyids}")
    public ResponseEntity<List<Product>> getFemaleProdFiltered(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,
            @PathVariable List<Integer> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(Integer x: propertyids){
            usn.addAll(productService.getHotFemaleProductListFiltered(x));

        }

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/gender/female/{page}/{size}/{sort}")
    public ResponseEntity<List<Product>> getFemaleProd(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort) {

        List<Product> usn = productService.getMaleProductList();

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/search/result/totalRecord/{page}/{size}/{keyword}")
    public ResponseEntity<Integer> totalSearchResultRecords(@PathVariable Integer page,@PathVariable Integer size,@PathVariable String keyword){
        List<Product> usn = productService.getProductListByKeyword(keyword);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }

    @GetMapping("/search/result/{page}/{size}/{sort}/{keyword}")
    public ResponseEntity<List<User>> searchProductsByKeyword(
            @PathVariable Integer page,@PathVariable Integer size,@PathVariable String sort,@PathVariable String keyword)  {
        List<Product> usn = productService.getProductListByKeyword(keyword);

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(Product::getName).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(Product::getName));
                break;
            case "MIN":
                usn.sort(Comparator.comparing(Product::getPrice));
                break;
            case "MAX":
                usn.sort(Comparator.comparing(Product::getPrice).reversed());
                break;
            default:
                usn.sort(Comparator.comparing(Product::getName));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
    @GetMapping("/getinfo/{id}")
    public ResponseEntity<Product> getProductInfoByID(@PathVariable Integer id){
       Product usn = productService.getProductById(id);
        return ResponseEntity.ok(usn);
    }

}
