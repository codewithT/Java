package net.javaProject.banking.service.impl;

import net.javaProject.banking.dto.AccountDto;
import net.javaProject.banking.dto.TransactionDto;
import net.javaProject.banking.entity.Account;
import net.javaProject.banking.entity.Transaction;
import net.javaProject.banking.mapper.TransactionMapper;
import net.javaProject.banking.repository.AccountRepository;
import net.javaProject.banking.repository.TransactionRepository;
import net.javaProject.banking.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    public TransactionRepository transactionRepository;
    @Autowired
    public AccountRepository accountRepository;
    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        if (transactionDto.getAccountId().equals(transactionDto.getToAccountId())) {
            throw new RuntimeException("Cannot transfer to self account");
        }

        Account account= accountRepository.findById(transactionDto.getAccountId()).orElseThrow(RuntimeException::new);
        Account updateToAccount = accountRepository.findById(transactionDto.getToAccountId()).orElseThrow(RuntimeException::new);
        Account accountToMap = accountRepository.findById(transactionDto.getAccountId()).orElseThrow(RuntimeException::new);
        Transaction transaction1 = TransactionMapper.mapToTransaction(transactionDto, accountToMap);
        account.getTransactions().add(transaction1);
        account.setBalance(account.getBalance() - transaction1.getAmount());
        accountRepository.save(account);
        updateToAccount.setBalance(updateToAccount.getBalance() + transaction1.getAmount());
        accountRepository.save(updateToAccount);
           Transaction savedTransaction =  transactionRepository.save(transaction1);
            return TransactionMapper.mapToTransactionDto(savedTransaction);
    }

    @Override
    public List<TransactionDto> getTransactionDetailsByID(Long Id) {
         Account account = accountRepository.findById(Id).orElseThrow(RuntimeException::new);
         List<Transaction> transactions = account.getTransactions();
        if(!transactions.isEmpty()) {
            List<TransactionDto> transactionDtos = new ArrayList<>();
            for (Transaction e : transactions) {
                transactionDtos.add(TransactionMapper.mapToTransactionDto(e));
            }

            return transactionDtos;
        }
        return new ArrayList<>();
    }

    @Override
    public List<TransactionDto> getTransactionDetailsByIDToId(Long Id1, Long Id2) {
        List<Transaction> transactionsList= transactionRepository.getAllTransactionFromIdToId(Id1, Id2);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for(Transaction e: transactionsList){
            transactionDtos.add(TransactionMapper.mapToTransactionDto(e));
        }
        return transactionDtos;
    }
}
