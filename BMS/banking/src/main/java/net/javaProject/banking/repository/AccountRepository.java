package net.javaProject.banking.repository;

import net.javaProject.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Jpa repository have two parameters 1. entity and 2. primary key.
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
