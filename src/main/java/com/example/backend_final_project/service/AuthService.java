package com.example.backend_final_project.service;

import com.example.backend_final_project.model.UsersToken;
import com.example.backend_final_project.service.Impl.AuthImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
import com.example.backend_final_project.service.Impl.UsersTokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.backend_final_project.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class AuthService implements UserDetailsService {
    @Autowired
    private UserServicelmpl userService;
    @Autowired
    private UsersTokenServiceImpl tokenService;


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.getUserByUsername(username);
               if(user.getUsername().equalsIgnoreCase(username)){
                   UsersToken userToken = tokenService.getUserTokenByUID(user.getId());
                   if(userToken.getAccountStatus()==1){
                       return AuthImpl.build(user);
                   } else { throw new UsernameNotFoundException("Account not activated: "+username);}
               } else{
                   throw new UsernameNotFoundException("User Not Found with Username: "+username);
               }
    }
    @Transactional
    public UserDetails loadUserByID(int id) throws UsernameNotFoundException {
        User user = userService.getUserById(id);
        if(user.getId()==(id)){
            UsersToken userToken = tokenService.getUserTokenByUID(user.getId());
            if(userToken.getAccountStatus()==1){
                return AuthImpl.build(user);
            } else { throw new UsernameNotFoundException("User with this ID not activated: "+id);}
        } else{
            throw new UsernameNotFoundException("User Not Found with UID: "+id);
        }
    }
}
