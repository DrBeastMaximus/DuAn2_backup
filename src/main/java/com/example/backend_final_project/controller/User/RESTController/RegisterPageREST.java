package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.MailSender;
import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.model.UsersToken;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.example.backend_final_project.service.Impl.UsersTokenServiceImpl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.Date;

@RestController
@RequestMapping("/api/auth/register")
public class RegisterPageREST {
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private UsersTokenServiceImpl tokenService;

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@Validated @RequestBody JsonNode json, HttpServletRequest request) throws MessagingException {
        String name = json.get("name").asText();
        String email = json.get("email").asText();
        String username = json.get("email").asText();
        String password = json.get("password").asText();
        User users = userService.getUserByUsername(username);
        User usr = userService.getUserByEmail(email);
        if(users==null){
            if(usr==null){
                User user = new User();
                user.setPassword(password);
                user.setUsername(username);
                user.setFullname(name);
                user.setEmail(email);
                user.setCreated_date(new Date());
                user.setUpdate_date(new Date());
                user.setIsdelete(false);
                userService.addUser(user);
                Date date = new Date();
                UsersToken tokens = new UsersToken();
                String token = TokenFactory.generateToken(user);
                tokens.setUser(user);
                tokens.setRegistrationTime(date);
                tokens.setEmailConfirmToken(token);
                tokens.setAccountStatus(0);
                UsersToken tk = tokenService.getUserTokenByUID(userService.getUserByUsername(username).getId());
                if(tk!=null){
                    tokenService.updateToken(tokens);
                } else{
                tokenService.addToken(tokens);}
                MailSender.sendText(user.getEmail(),
                        "Link kích hoạt tài khoản DW Fashion của bạn",
                        "Link: "+"http://dwhigh.tech:8080"+ "/api/auth/register/emailconfirm/"+token);
                return ResponseEntity.accepted().body("Tạo User thành công");
            } else {
                return ResponseEntity.badRequest().body("Email đã được sử dụng");
            }
        } else {
            return ResponseEntity.badRequest().body("Username đã được sử dụng");
        }

    }

    @GetMapping("/emailconfirm/{token}")
    public ResponseEntity<?> confirmEmail(@PathVariable String token){
        if(TokenFactory.validateToken(token)){
        String id = TokenFactory.getUserIdFromJWT(token);
        User user = userService.getUserById(Integer.parseInt(id));
        if(user!=null){
            UsersToken tokens = tokenService.getUserTokenByUID(Integer.parseInt(id));
            if(token.equals(tokens.getEmailConfirmToken())) {
                tokens.setEmailConfirmToken(null);
                tokens.setAccountStatus(1);
                tokenService.updateToken(tokens);
                return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("https://dwhigh.tech/")).build();
            } else {return ResponseEntity.ok("Token is not valid");}
        }else{
            return ResponseEntity.ok("Token is not valid");
            }
        } else{
            return ResponseEntity.ok("Token is not valid");
        }
    }
}
