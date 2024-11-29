package net.javaProject.banking.repository;

import net.javaProject.banking.entity.Account;
import net.javaProject.banking.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
        @Query("Select t from Transaction t where t.account.Id = :Id1 and t.toAccountId = :Id2")
        List<Transaction> getAllTransactionFromIdToId(Long Id1, Long Id2);
}
