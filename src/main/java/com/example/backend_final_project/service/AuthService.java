package com.example.backend_final_project.service;

import com.example.backend_final_project.service.Impl.AuthImpl;
import com.example.backend_final_project.service.Impl.UserServicelmpl;
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

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user = userService.getUserByUsername(username);
               if(user.getUsername().equalsIgnoreCase(username)){
                   return AuthImpl.build(user);
               } else{
                   throw new UsernameNotFoundException("User Not Found with Username: "+username);
               }
    }
    @Transactional
    public UserDetails loadUserByID(int id) throws UsernameNotFoundException {
        User user = userService.getUserById(id);
        if(user.getId()==(id)){
            return AuthImpl.build(user);
        } else{
            throw new UsernameNotFoundException("User Not Found with UID: "+id);
        }
    }
}
