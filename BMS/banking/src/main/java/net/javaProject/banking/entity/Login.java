package net.javaProject.banking.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Login {
    Long idLogin;
    String userName ;
    String password;

    public Login(Long idLogin, String userName, String password) {
        this.idLogin = idLogin;
        this.userName = userName;
        this.password = password;
    }

    public Long getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(Long idLogin) {
        this.idLogin = idLogin;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
