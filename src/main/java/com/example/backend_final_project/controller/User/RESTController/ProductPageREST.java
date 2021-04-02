package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.Product_Image;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.ProductImageServiceImpl;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

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
    @GetMapping("/gender/male/totalRecord/{size}/{propertyids}")
    public ResponseEntity<Integer> totalMaleProdRecordsFiltered(@PathVariable Integer size,@PathVariable List<String> propertyids){
        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
            usn.addAll(productService.getHotMaleProductListFiltered(x));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/totalRecord/{size}/{min}/{max}/{propertyids}")
    public ResponseEntity<Integer> totalMaleProdRecordsFilteredInRange(@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max,@PathVariable List<String> propertyids){
        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
            usn.addAll(productService.getHotMaleProductListFilteredInRange(x,min,max));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/female/totalRecord/{size}/{min}/{max}/{propertyids}")
    public ResponseEntity<Integer> totalFemaleProdRecordsFilteredInRange(@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max,@PathVariable List<String> propertyids){
        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
            usn.addAll(productService.getHotFemaleProductListFilteredInRange(x,min,max));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/female/totalRecord/{size}/{min}/{max}")
    public ResponseEntity<Integer> totalFemaleProdRecordsInRange(@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max){
        List<Product> usn = productService.getHotFemaleProductListInRange(min,max);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/totalRecord/{size}/{min}/{max}")
    public ResponseEntity<Integer> totalMaleProdRecordsInRange(@PathVariable Integer size,@PathVariable Long min, @PathVariable Long max){
        List<Product> usn = productService.getHotMaleProductListInRange(min,max);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);


        return ResponseEntity.ok(pg.getPageCount());
    }

    @GetMapping("/gender/female/totalRecord/{size}/{propertyids}")
    public ResponseEntity<Integer> totalFemaleProdRecordsFiltered(@PathVariable Integer size,@PathVariable List<String> propertyids){
        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
            usn.addAll(productService.getHotFemaleProductListFiltered(x));

        }
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/male/totalCount/")
    public ResponseEntity<Long> totalMaleProdCount(){
        List<Product> usn = productService.getMaleProductList();
        return ResponseEntity.ok(usn.stream().count());
    }
    @GetMapping("/gender/female/totalCount/")
    public ResponseEntity<Long> totalFemaleProdCount(){
        List<Product> usn = productService.getFemaleProductList();
        return ResponseEntity.ok(usn.stream().count());
    }
    @GetMapping("/gender/male/totalRecord/{size}")
    public ResponseEntity<Integer> totalMaleProdRecords(@PathVariable Integer size){
        List<Product> usn = productService.getMaleProductList();
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/gender/female/totalRecord/{size}")
    public ResponseEntity<Integer> totalFemaleProdRecords(@PathVariable Integer size){
        List<Product> usn = productService.getFemaleProductList();
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

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
        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
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
        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
    }
    @GetMapping("/gender/male/{page}/{size}/{sort}/{propertyids}")
    public ResponseEntity<List<Product>> getMaleProdFiltered(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,
            @PathVariable List<String> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
    }
    @GetMapping("/gender/male/{page}/{size}/{sort}/{min}/{max}/{propertyids}")
    public ResponseEntity<List<Product>> getMaleProdFilteredInRange(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,@PathVariable Long min, @PathVariable Long max,
            @PathVariable List<String> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
    }
    @GetMapping("/gender/female/{page}/{size}/{sort}/{min}/{max}/{propertyids}")
    public ResponseEntity<List<Product>> getFemaleProdFilteredInRange(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,@PathVariable Long min, @PathVariable Long max,
            @PathVariable List<String> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
    }
    @GetMapping("/gender/female/{page}/{size}/{sort}/{propertyids}")
    public ResponseEntity<List<Product>> getFemaleProdFiltered(
            @PathVariable Integer page,
            @PathVariable Integer size,
            @PathVariable String sort,
            @PathVariable List<String> propertyids) {

        List<Product> usn = new ArrayList<>();
        for(String x: propertyids){
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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
    }
    @GetMapping("/search/result/totalRecord/{size}/{keyword}")
    public ResponseEntity<Integer> totalSearchResultRecords(@PathVariable Integer size,@PathVariable String keyword){
        List<Product> usn = productService.getProductListByKeyword(keyword);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

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

        List ls = new ArrayList();
        List<Product> pd = pg.getPageList();

        for(int i=0;i<pd.size();i++){
            Map<String, Object> obj = new LinkedHashMap<>();
            obj.put("product",pd.get(i));
            String indexImg = "http://dwhigh.tech:8080/api/image/getIndexImages/"+pd.get(i).getID();
            obj.put("indexImage",indexImg);
            ls.add(obj);
        }
        return ResponseEntity.ok(ls);
    }
    @GetMapping("/getinfo/{id}")
    public ResponseEntity<Product> getProductInfoByID(@PathVariable Integer id){
       Product usn = productService.getProductById(id);
        return ResponseEntity.ok(usn);
    }

}
