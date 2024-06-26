package com.ovindupeiris.Expense.Tracker.controller;

import com.ovindupeiris.Expense.Tracker.entity.Transaction;
import com.ovindupeiris.Expense.Tracker.enums.Error;
import com.ovindupeiris.Expense.Tracker.exception.ResourceNotFoundException;
import com.ovindupeiris.Expense.Tracker.model.ErrorResponse;
import com.ovindupeiris.Expense.Tracker.model.SuccessResponse;
import com.ovindupeiris.Expense.Tracker.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTrasactionById(@PathVariable("id") Long id){
        try{
            Transaction transaction = transactionService.getTransaction(id);
            SuccessResponse response = new SuccessResponse();
            response.setStatus(Error.SUCCESS.getStatus());
            response.setData(transaction);
            return ResponseEntity.ok().body(response);

        }catch (Exception ex){
            ErrorResponse error = new ErrorResponse();
            error.setStatus(Error.GENERAL_ERROR.getStatus());
            error.setError(ex.getLocalizedMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

    @GetMapping("/user/{userid}")
    public ResponseEntity<?> getUserTransaction(@PathVariable("userid") Long userid) throws ResourceNotFoundException {
        try {
            List<Transaction> transactions = transactionService.getUserTransactions(userid);
            if (!transactions.isEmpty()) {
                SuccessResponse response = new SuccessResponse();
                response.setStatus(Error.SUCCESS.getStatus());
                response.setData(transactions);
                return ResponseEntity.ok().body(response);
            } else {
                ErrorResponse error = new ErrorResponse();
                error.setStatus(Error.NO_TRANSACTIONS_FOUND.getStatus());
                error.setError(Error.NO_TRANSACTIONS_FOUND.getDescription());
                return ResponseEntity.status(404).body(error);
            }
        } catch (Exception ex) {
            ErrorResponse error = new ErrorResponse();
            error.setStatus(Error.GENERAL_ERROR.getStatus());
            error.setError(ex.getLocalizedMessage());
            return ResponseEntity.internalServerError().body(error);
        }
    }

}
