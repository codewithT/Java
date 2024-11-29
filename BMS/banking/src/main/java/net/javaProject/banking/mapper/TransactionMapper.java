package net.javaProject.banking.mapper;

import net.javaProject.banking.dto.TransactionDto;
import net.javaProject.banking.entity.Account;
import net.javaProject.banking.entity.Transaction;
import net.javaProject.banking.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class TransactionMapper {
    public static Transaction mapToTransaction(TransactionDto transactionDto , Account account) {

        LocalDate currentDate = LocalDate.now();
        return new Transaction(
                transactionDto.getId(),
                currentDate,
                transactionDto.getToAccountId(),
                transactionDto.getTypeOfTransaction(),
                transactionDto.getAmount(),
                account
        );
    }

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        return new TransactionDto(
        transaction.getId(),
        transaction.getToAccountId(),
        transaction.getTypeOfTransaction(),
                transaction.getAmount(),
                transaction.getAccount().getId()
        );
    }
}
