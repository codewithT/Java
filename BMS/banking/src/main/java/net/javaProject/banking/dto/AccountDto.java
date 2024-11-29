package net.javaProject.banking.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import net.javaProject.banking.entity.Account;
import net.javaProject.banking.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

@Data

public class AccountDto {

    private Long id;
    private Long accountNumber;
    private String accountHolderName;

    private double balance;

    public AccountDto(Long id, String accountHolderName, double balance) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

    }

    public Long getId() {
        return id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }




}
