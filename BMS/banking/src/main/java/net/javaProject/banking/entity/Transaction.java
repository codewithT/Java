package net.javaProject.banking.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "transaction_date")
    private LocalDate currentDate;
    private Long toAccountId;
    private String typeOfTransaction;
    private Long amount;


    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    private Transaction() {

    }


    public Transaction(Long Id, LocalDate currentDate, Long toAccountId, String typeOfTransaction, Long amount, Account account) {
        this.Id= Id;
        this.currentDate = currentDate;
        this.toAccountId = toAccountId;
        this.typeOfTransaction= typeOfTransaction;
        this.amount = amount;
        this.account = account;
    }


    public Long getId() {
        return Id;
    }



    public Long getToAccountId() {
        return toAccountId;
    }


    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }



    public Long getAmount() {
        return amount;
    }


    public Account getAccount() {
        return account;
    }


}
