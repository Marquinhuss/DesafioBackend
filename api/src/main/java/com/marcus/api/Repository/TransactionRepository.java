package com.marcus.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.api.Model.Transaction.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{
    
}
