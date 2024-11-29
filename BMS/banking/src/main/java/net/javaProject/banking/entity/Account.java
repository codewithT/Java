package net.javaProject.banking.entity;

import jakarta.persistence.*;
import lombok.Data;
import net.javaProject.banking.repository.AccountRepository;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long accountNumber;
    private String accountHolderName;
    private double balance;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Account(){

    }
    public Account(Long id, String accountHolderName, double balance, List<Transaction> transactions) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions= transactions;
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

    public void setBalance(double total) {
        this.balance = total;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }


}
