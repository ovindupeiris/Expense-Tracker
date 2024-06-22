package com.ovindupeiris.Expense.Tracker.service;

import com.ovindupeiris.Expense.Tracker.entity.Transaction;
import com.ovindupeiris.Expense.Tracker.exception.ResourceNotFoundException;

import java.util.List;

public interface TransactionService {
    List<Transaction> getUserTransactions(Long userid) throws ResourceNotFoundException;

    Transaction getTransaction(Long id) throws ResourceNotFoundException;
}
