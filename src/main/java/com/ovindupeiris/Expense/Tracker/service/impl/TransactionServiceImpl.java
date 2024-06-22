package com.ovindupeiris.Expense.Tracker.service.impl;

import com.ovindupeiris.Expense.Tracker.entity.Transaction;
import com.ovindupeiris.Expense.Tracker.entity.User;
import com.ovindupeiris.Expense.Tracker.enums.Error;
import com.ovindupeiris.Expense.Tracker.exception.ResourceNotFoundException;
import com.ovindupeiris.Expense.Tracker.repository.TransactionRepository;
import com.ovindupeiris.Expense.Tracker.repository.UserRepository;
import com.ovindupeiris.Expense.Tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private final TransactionRepository transactionRepository;

    @Autowired
    private final UserRepository userRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Transaction> getUserTransactions(Long userid) throws ResourceNotFoundException {
        Optional<User> user = userRepository.findById(userid);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException(Error.USER_NOT_FOUND.getStatus(),
                    Error.USER_NOT_FOUND.getDescription());
        }
        try {
            return transactionRepository.findByAccountUserIdOrderByDateDesc(userid);
        } catch (Exception e) {
            throw new RuntimeException(Error.FAILED_TO_RETRIEVE_TRANSACTIONS.getDescription());
        }
    }

    @Override
    public Transaction getTransaction(Long id) throws ResourceNotFoundException {
        Optional<Transaction> transaction = transactionRepository.findById(id);
        if (transaction.isEmpty()) {
            throw new ResourceNotFoundException(Error.NO_TRANSACTIONS_FOUND.getStatus(),
                    Error.NO_TRANSACTIONS_FOUND.getDescription());
        } else {
            return transaction.get();
        }
    }
}
