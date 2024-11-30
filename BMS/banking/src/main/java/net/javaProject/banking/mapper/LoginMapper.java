package net.javaProject.banking.mapper;

import net.javaProject.banking.dto.LoginDto;
import net.javaProject.banking.entity.Login;

public class LoginMapper {



    public static LoginDto mapToLoginDto(Login login){
        return new LoginDto(
                login.getIdLogin(),
                login.getUserName(),
                login.getPassword()
        );
    }
    public static Login mapToLogin(LoginDto loginDto){
        return new Login(
                loginDto.getIdLogin(),
                loginDto.getUserName(),
                loginDto.getPassword()
        );
    }
}
