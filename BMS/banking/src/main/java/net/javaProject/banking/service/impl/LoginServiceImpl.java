package net.javaProject.banking.service.impl;

import lombok.extern.java.Log;
import net.javaProject.banking.dto.LoginDto;
import net.javaProject.banking.entity.Login;
import net.javaProject.banking.mapper.LoginMapper;
import net.javaProject.banking.repository.LoginRepository;
import net.javaProject.banking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private  JwtServiceImpl jwtService;
    @Autowired
    AuthenticationManager authManager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public LoginDto signUp(LoginDto loginDto) {
        Optional<Login> loginDto1= loginRepository.findById(loginDto.getIdLogin());
        if(loginDto1.isPresent()){
           throw new  RuntimeException();
        }
        loginDto.setPassword(encoder.encode(loginDto.getPassword()));
        Login login = LoginMapper.mapToLogin(loginDto);
        loginRepository.save(login);
        return loginDto;
    }

    @Override
    public String  login(LoginDto loginDto) {
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUserName(), loginDto.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(loginDto.getUserName());
        } else {
            return "fail";
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
