package com.ovindupeiris.Expense.Tracker.repository;

import com.ovindupeiris.Expense.Tracker.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}