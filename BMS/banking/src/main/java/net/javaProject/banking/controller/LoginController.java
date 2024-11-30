package net.javaProject.banking.controller;

import net.javaProject.banking.dto.LoginDto;
import net.javaProject.banking.entity.Login;
import net.javaProject.banking.service.LoginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/BMS/auth")
public class LoginController {
    public  LoginService loginService;
    @PostMapping("/signUp")
    public LoginDto signUp(@RequestBody LoginDto loginDto){
       return loginService.signUp(loginDto);
    }

}
