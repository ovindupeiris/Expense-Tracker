package com.ovindupeiris.Expense.Tracker.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private String status;
    private Object error;
}
