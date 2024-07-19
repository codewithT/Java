package net.javaProject.banking.mapper;

import net.javaProject.banking.dto.AccountDto;
import net.javaProject.banking.entity.Account;

public class AccountMapper {
    // saving data into database
    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
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
