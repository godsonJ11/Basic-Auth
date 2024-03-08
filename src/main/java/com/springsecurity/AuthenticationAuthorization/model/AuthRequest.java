package com.springsecurity.AuthenticationAuthorization.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String name;
    private String password;
}
