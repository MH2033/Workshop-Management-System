package com.project.workshopmanagment.security;

import java.util.HashMap;
import java.util.Map;

public class LoginPrincipal {
    private String id;
    private String password;
    private String email;

    public LoginPrincipal(Object principal) {
        Map map = (HashMap) principal;
        id = (String) map.get("id");
        password = (String) map.get("password");
        email = (String)map.get("email");
    }

    public LoginPrincipal(String id, String password,String email) {
        this.id = id;
        this.password = password;
        this.email = email;
    }

    public LoginPrincipal(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}