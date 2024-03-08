package com.springsecurity.AuthenticationAuthorization.service;

import com.springsecurity.AuthenticationAuthorization.model.AUTHENTICATION_ROLE;
import com.springsecurity.AuthenticationAuthorization.model.Users;
import com.springsecurity.AuthenticationAuthorization.model.UsersDTO;
import com.springsecurity.AuthenticationAuthorization.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.InvalidClassException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public String storeTheUser(UsersDTO usersDTO) {
        try {
            userRepository.save(Users.builder()
                    .name(usersDTO.getName())
                    .email(usersDTO.getEmail())
                    .role(AUTHENTICATION_ROLE.ROLE_USER)
                    .password(passwordEncoder.encode(usersDTO.getPassword()))
                    .isAccountNonExpired(true)
                    .isAccountNonLocked(true)
                    .isCredentialsNonExpired(true)
                    .isEnabled(true)
                    .build());
        } catch (Exception exception) {
            return "Please try again";
        }
        return "user stored successfully";
    }

    public Users fetchAllUserByID(Integer id) {
        return userRepository.findById(id).get();
    }

}
