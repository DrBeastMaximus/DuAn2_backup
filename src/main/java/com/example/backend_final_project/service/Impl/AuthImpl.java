package com.example.backend_final_project.service.Impl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import com.example.backend_final_project.model.User;
import java.util.Collection;

public class AuthImpl implements UserDetails {
    private static final long serialVersionUID= 1L;
    private Long id;
    private String username;

    private String email;

    public AuthImpl(Long id, String username, String email, String password){
        this.id=id;
        this.username=username;
        this.email=email;
        this.password=password;
    }

    public static AuthImpl build(User user){
        return  new AuthImpl((long) user.getId(),user.getUsername(),user.getEmail(),user.getPassword());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonIgnore
    private String password;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
