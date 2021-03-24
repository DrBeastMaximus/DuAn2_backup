package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.model.Comment;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.service.Impl.CommentServiceImpl;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product/comment")
public class CommentREST {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/loadProductComment/{page}/{size}/{prodID}")
    public ResponseEntity<?> loadProductComment(@PathVariable Integer page, @PathVariable Integer size,@PathVariable Integer prodID){
        List<Comment> usn = commentService.getCommentListByProductId(prodID);
        if(usn!=null){
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(usn);}
        else{
            return ResponseEntity.badRequest().body("Không có comment");
        }
    }
    @GetMapping("/loadProductComment/pageCount/{size}/{prodID}")
    public ResponseEntity<Integer> loadProductCommentPageCount( @PathVariable Integer size,@PathVariable Integer prodID){
        List<Comment> usn = commentService.getCommentListByProductId(prodID);
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);

        return ResponseEntity.ok(pg.getPageCount());
    }
}
