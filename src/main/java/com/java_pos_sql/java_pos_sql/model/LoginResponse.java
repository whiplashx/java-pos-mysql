package com.java_pos_sql.java_pos_sql.model;

import java.util.List;

public class LoginResponse {

    private String token;
    private String type;
    private String username;
    private List<String> roles;

    public LoginResponse(String token, String type, String username, List<String> roles) {
        this.token = token;
        this.type = type;
        this.username = username;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public String getType() {
        return type;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }
}