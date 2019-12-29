package com.project.workshopmanagment.security;

import java.util.HashMap;
import java.util.Map;

public class LoginPrincipal {
    private String id;
    private String password;

    public LoginPrincipal(Object principal) {
        Map map = (HashMap) principal;
        id = (String) map.get("id");
        password = (String) map.get("password");
    }

    public LoginPrincipal(String id, String password) {
        this.id = id;
        this.password = password;
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
}