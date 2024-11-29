package net.javaProject.banking.service;

import lombok.extern.java.Log;
import net.javaProject.banking.dto.LoginDto;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginService {
    LoginDto signUp(LoginDto loginDto);
    String login(LoginDto loginDto);

    UserDetails loadUserByUsername(String username);
}
