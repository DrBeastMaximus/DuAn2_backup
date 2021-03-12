package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.MailSender;
import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.model.UsersToken;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.example.backend_final_project.service.Impl.UsersTokenServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/api/auth/register")
public class RegisterPageREST {
    @Autowired
    private UserServicelmpl userService;
    private UsersTokenServiceImpl tokenService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Validated @RequestBody User user, HttpServletRequest request) throws MessagingException {
        User users = userService.getUserByUsername(user.getUsername());
        User usr = userService.getUserByEmail(user.getEmail());
        if(users!=null){
            if(usr!=null){
                userService.addUser(user);
                Date date = new Date();
                UsersToken tokens = new UsersToken();
                String token = TokenFactory.generateToken(user);
                tokens.setUser(user);
                tokens.setRegistrationTime(date);
                tokens.setEmailConfirmToken(token);
                tokens.setAccountStatus(0);
                tokenService.addToken(tokens);
                MailSender.sendText(user.getEmail(),
                        "Link kích hoạt tài khoản DW Fashion của bạn",
                        "Link:"+request.getContextPath()+ "/api/auth/register/emailconfirm/"+token);
                return ResponseEntity.accepted().body("Tạo User thành công");
            } else {return ResponseEntity.badRequest().body("Email đã được sử dụng");}
        } else {return ResponseEntity.badRequest().body("Username đã được sử dụng");}

    }

    @GetMapping("/emailconfirm/{token}")
    public boolean confirmEmail(@PathVariable String token){
        if(TokenFactory.validateToken(token)){
        String id = TokenFactory.getUserIdFromJWT(token);
        User user = userService.getUserById(Integer.parseInt(id));
        if(user!=null){
            UsersToken tokens = tokenService.getUserTokenByUID(Integer.parseInt(id));
            tokens.setEmailConfirmToken(null);
            tokens.setAccountStatus(1);
            tokenService.updateToken(tokens);
            return true;
        }else{
            return false;
            }
        } else{
            return false;
        }
    }
}
