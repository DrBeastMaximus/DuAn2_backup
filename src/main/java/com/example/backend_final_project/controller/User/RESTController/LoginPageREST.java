package com.example.backend_final_project.controller.User.RESTController;

import com.example.backend_final_project.Utils.TokenFactory;
import com.example.backend_final_project.exception.DeleteDataException;
import com.example.backend_final_project.exception.SaveDataErrorException;
import com.example.backend_final_project.model.User;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.example.backend_final_project.service.dto.JwtResponse;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/login")
public class LoginPageREST {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private UserServicelmpl userServicelmpl;

    @GetMapping("/checkValidToken/{token}")
    public boolean checkValidToken(@PathVariable String token){
        if(TokenFactory.validateToken(token)){
            return true;
        } else{
            return false;
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> SignIn(@RequestBody JsonNode json){
        String password = json.get("password").asText();
        String username = json.get("username").asText();

        User user = userServicelmpl.getUserByUsername(username);
        if(user!=null){
            if(password.equals(user.getPassword())){
                Authentication auth = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(username,password));
                SecurityContextHolder.getContext().setAuthentication(auth);
                String token = TokenFactory.generateToken2(auth, user);
                return ResponseEntity.ok(new JwtResponse(token,user.getId(),user.getUsername(),user.getEmail()));
            } else{
                return ResponseEntity.badRequest().body("Username hoặc mật khẩu không đúng!");
            }
        }
        return ResponseEntity.badRequest().body("Username hoặc mật khẩu không đúng!");
    }


}
