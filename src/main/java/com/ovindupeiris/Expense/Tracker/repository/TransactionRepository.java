package com.ovindupeiris.Expense.Tracker.repository;

import com.ovindupeiris.Expense.Tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountUserIdOrderByDateDesc(Long id);
}