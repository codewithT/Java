package net.javaProject.banking.mapper;

import net.javaProject.banking.dto.AccountDto;
import net.javaProject.banking.entity.Account;
import net.javaProject.banking.entity.Transaction;

import java.util.ArrayList;
import java.util.List;

public class AccountMapper {
    // saving data into database
    public static Account mapToAccount(AccountDto accountDto , List<Transaction> transactionList) {

        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                transactionList
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
    }
}
