package com.springsecurity.AuthenticationAuthorization.controller;

import com.springsecurity.AuthenticationAuthorization.model.Users;
import com.springsecurity.AuthenticationAuthorization.model.UsersDTO;
import com.springsecurity.AuthenticationAuthorization.service.UserInfoConfigService;
import com.springsecurity.AuthenticationAuthorization.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfoConfigService userInfoConfigService;
    private AuthenticationManager authenticationManager;

    @PostMapping("/user")
    public String storeTheUser(@RequestBody UsersDTO usersDTO) {
        return userService.storeTheUser(usersDTO);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    //role must be same in enum ROLE_USER
    @GetMapping("/user/{id}")
    public Users fetchTheUserById(@PathVariable("id") Integer id) {
        return userService.fetchAllUserByID(id);
    }

    @GetMapping("/users")
    public String fetchTheUserByIds() {
        return "hello";
    }
}
