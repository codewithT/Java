package net.javaProject.banking.repository;

import net.javaProject.banking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
// Jpa repository have two parameters 1. entity and 2. primary key.
public interface AccountRepository extends JpaRepository<Account, Long> {

}
