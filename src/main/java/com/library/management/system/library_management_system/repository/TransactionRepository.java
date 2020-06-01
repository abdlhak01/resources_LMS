package com.library.management.system.library_management_system.repository;

import com.library.management.system.library_management_system.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    Transaction findFirstByOrderByTransactionId();
    Transaction findByTransactionCode(String codeTrans);
    boolean existsByTransactionCode(String codeTrans);
}
