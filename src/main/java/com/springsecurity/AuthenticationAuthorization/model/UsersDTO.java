package com.springsecurity.AuthenticationAuthorization.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UsersDTO {
    private String name;
    private String password;
    private String email;
}
