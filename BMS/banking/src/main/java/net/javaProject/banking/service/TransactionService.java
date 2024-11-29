package net.javaProject.banking.service;

import net.javaProject.banking.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> getTransactionDetailsByID(Long Id);
    List<TransactionDto> getTransactionDetailsByIDToId(Long Id1, Long Id2 );
}
