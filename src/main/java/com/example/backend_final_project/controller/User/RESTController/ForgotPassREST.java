package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.MailSender;
import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.model.UsersToken;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.example.backend_final_project.service.Impl.UsersTokenServiceImpl;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequestMapping("/api/auth/forgot")
public class ForgotPassREST {
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private UsersTokenServiceImpl tokenService;

    @GetMapping("/{email}")
    public boolean resetPassword(@PathVariable String email, HttpServletRequest request) throws MessagingException {
        User user = userService.getUserByEmail(email);
        if(user!=null){
            String token = TokenFactory.generateToken(user);
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.DATE, 1);
            UsersToken tokens = tokenService.getUserTokenByUID(user.getId());
            tokens.setPasswordReminderToken(token);
            tokens.setPasswordReminderExpire(c.getTime());
            tokenService.updateToken(tokens);
            MailSender.sendText(user.getEmail(),
                    "Link khôi phục tài khoản DW Fashion của bạn",
                    "Link:"+"http://dwhigh.tech:8080"+ "/api/auth/forgot/emailconfirm/"+token);
            return true;
        } else{
            return false;
        }
    }
    @GetMapping("/emailconfirm/{token}")
    public boolean confirmEmail(@PathVariable String token){
        if(TokenFactory.validateToken(token)) {
            String id = TokenFactory.getUserIdFromJWT(token);
            User user = userService.getUserById(Integer.parseInt(id));

            if (user != null) {
                UsersToken tokens = tokenService.getUserTokenByUID(Integer.parseInt(id));
                if (tokens.getPasswordReminderExpire().equals(new Date())) {
                    tokens.setPasswordReminderExpire(null);
                    tokens.setPasswordReminderToken(null);
                    tokenService.updateToken(tokens);
                    return false;
                } else {
                    tokens.setAccountStatus(3);
                    tokenService.updateToken(tokens);
                    return true;
                }

            } else {
                return false;
            }
        } else{return false;}
    }

    @PostMapping("/recover")
    public ResponseEntity<?> recover(@RequestBody JsonNode json){
        String token = json.get("token").asText();
        String newPass = json.get("newPassword").asText();
        String confirm = json.get("confirm").asText();
        if (StringUtils.hasText(token) && TokenFactory.validateToken(token)) {
            int userId = Integer.parseInt(TokenFactory.getUserIdFromJWT(token));
            User usr = userService.getUserById(userId);
            if (usr != null) {
                UsersToken tokens = tokenService.getUserTokenByUID(userId);
                if(tokens.getAccountStatus()==3){
                    if(confirm.equals(newPass)){
                        usr.setPassword(newPass);
                        userService.updateUser(usr);
                        tokens.setPasswordReminderExpire(null);
                        tokens.setPasswordReminderToken(null);
                        tokens.setAccountStatus(1);
                        tokenService.updateToken(tokens);
                        return ResponseEntity.ok("Đã khôi phục tài khoản thành công");
                    } else{return ResponseEntity.ok("Mật khẩu không đúng với xác nhận");}
                } else {
                return ResponseEntity.ok("Link khôi phục tài khoản sai hoặc hết hạn");}
            } else {
                return ResponseEntity.ok("Link khôi phục tài khoản sai hoặc hết hạn");
            }
        }{return ResponseEntity.ok("Link khôi phục tài khoản sai hoặc hết hạn");}
    }



}
