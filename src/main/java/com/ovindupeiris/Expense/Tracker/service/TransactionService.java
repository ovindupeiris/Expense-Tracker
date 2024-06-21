package com.ovindupeiris.Expense.Tracker.service;

import com.ovindupeiris.Expense.Tracker.entity.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getUserTransactions(Long userid);
}
