package com.ovindupeiris.Expense.Tracker.model;

import lombok.Data;

@Data
public class ErrorResponse {
    private Integer status;
    private Object error;
}
