package com.swe206.group_two.backend.auth;

public class AuthDTO {
    private String email;
    private String password;

    public AuthDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
