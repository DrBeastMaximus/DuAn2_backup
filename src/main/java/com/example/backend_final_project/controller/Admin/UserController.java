package com.example.backend_final_project.controller.Admin;

import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.model.Product;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.ProductServiceImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServicelmpl userServicelmpl;

    @GetMapping("")
    public List<User> helloword(){
        List<User>  list = userServicelmpl.getUserList();
        System.out.println("test............");
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
    @GetMapping("/delete")
    public String delete(@RequestParam("id") int id) throws DeleteDataException {
        User usr = userServicelmpl.getUserById(id);
        if(usr!=null){
            userServicelmpl.deleteUser(usr);
            return "Delete functioning ok!";
        } else{
            throw new DeleteDataException();
        }
    }
}
