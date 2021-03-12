package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.data.domain.*;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/user2")
public class UserController {

    @Autowired
    private UserServicelmpl userServicelmpl;

    @GetMapping("")
    public List<User> helloword(){
        List<User>  list = userServicelmpl.getUserList();
        System.out.println("User list loaded successfully!");
        return list;
    }
    @GetMapping("/find")
    public List<User> index(@RequestParam("keyword") String keyword) {
        return userServicelmpl.findUserByKeyword(keyword);
    }

    @GetMapping("/add")
    public String add(@RequestParam("username") String usn,@RequestParam("password") String pwd) throws SaveDataErrorException {
        User usr = new User();
        Date date = new Date();
        usr.setAddress("SSS");
        usr.setBirthday(date);
        usr.setCreated_date(date);
        usr.setFullname("ABC");
        usr.setEmail("CCC");
        usr.setFullname("FFF");
        usr.setGender(true);
        usr.setPassword(pwd);
        usr.setPhone("555");
        usr.setUpdate_date(date);
        usr.setUsername(usn);
        usr.setIsdelete(false);
        if(userServicelmpl.getUserByUsername(usn)==null) {
            userServicelmpl.addUser(usr);
            return "Add functioning ok!";
        } else {
            throw new SaveDataErrorException();
        }

    }
    @GetMapping("/edit")
    public String update(@RequestParam("username") String usn,@RequestParam("password") String pwd) throws SaveDataErrorException {
        User usr = userServicelmpl.getUserByUsername(usn);
        if(usr!=null) {
        Date date = new Date();
        usr.setAddress("SSS");
        usr.setBirthday(date);
        usr.setCreated_date(date);
        usr.setFullname("ABC");
        usr.setEmail("CCC");
        usr.setFullname("FFF");
        usr.setGender(true);
        usr.setPassword(pwd);
        usr.setPhone("555");
        usr.setUpdate_date(date);
        usr.setUsername(usn);
        usr.setIsdelete(false);
            userServicelmpl.updateUser(usr);
            return "Update functioning ok!";
        } else {
            throw new SaveDataErrorException();
        }

    }
    //Đang làm thử Add, Delete, Update cho user. Delete bị lỗi vẫn chưa fix đc
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) throws DeleteDataException {
        User usr = userServicelmpl.getUserById(id);
        if(usr!=null){
            userServicelmpl.deleteUser(usr.getId());
            return "Delete functioning ok!";
        } else{
            throw new DeleteDataException();
        }
    }

    @GetMapping("/paging")
    public List listCustomer(Model model,
                             @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                             @RequestParam(name = "size", required = false, defaultValue = "1") Integer size,
                             @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        if(sort=="ASC"){
        List<User> usr = userServicelmpl.getPagination(page,size);
        Collections.sort(usr, Comparator.comparing(User::getUsername));
        return usr;
        } else if(sort=="DESC"){
            List<User> usr = userServicelmpl.getPagination(page,size);
            Collections.sort(usr, new Comparator<User>() {
                @Override
                public int compare(User u1, User u2) {
                    return (u1.getUsername().compareToIgnoreCase(u2.getUsername()));
                }
            });
            return usr;
        }
        else{
            return userServicelmpl.getPagination(page,size);
        }
    }
    @GetMapping("/totalpaging")
    public ResponseEntity<Integer> totalRecords( @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                                 @RequestParam(name = "size", required = false, defaultValue = "1") Integer size){
        List<User> usn = userServicelmpl.getUserList();
        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageCount());
    }
    @GetMapping("/paging2")
    public ResponseEntity<List<User>> listCustomer2(
                              @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                              @RequestParam(name = "size", required = false, defaultValue = "16") Integer size,
                              @RequestParam(name = "sort", required = false, defaultValue = "DESC") String sort) {

//        Page<User> usr = new PageImpl<User>(userServicelmpl.getUserList(PageRequest.of(page,size)));
        List<User> usn = userServicelmpl.getUserList();

        switch (sort){
            case "DESC":
                usn.sort(Comparator.comparing(User::getUsername).reversed());
                break;
            case "ASC":
                usn.sort(Comparator.comparing(User::getUsername));
                break;
        }

        PagedListHolder pg = new PagedListHolder(usn);
        pg.setPageSize(size);
        pg.setPage(page);

        return ResponseEntity.ok(pg.getPageList());
    }
}
