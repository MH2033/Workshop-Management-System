package com.project.workshopmanagment.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UserPrincipal implements UserDetails {
    private String id;
    private String password;

//    public LoginPrincipal(Object principal) {
//        Map map = (HashMap) principal;
//        id = (String) map.get("id");
//        password = (String) map.get("password");
//    }
//
//    public LoginPrincipal(String id, String password) {
//        this.id = id;
//        this.password = password;
//    }
//
//    public LoginPrincipal(String id) {
//        this.id = id;
//    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}