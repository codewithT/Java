package net.javaProject.banking.dto;


import lombok.Data;

@Data
public class TransactionDto {
    private Long Id;
    private Long toAccountId;
    private String typeOfTransaction;
    private Long amount;
    private Long accountId;

    public TransactionDto(Long Id, Long toAccountId, String typeOfTransaction, Long amount , Long accountId) {
        this.Id= Id;

        this.toAccountId = toAccountId;
        this.typeOfTransaction= typeOfTransaction;
        this.amount = amount;
        this.accountId = accountId;
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


    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
