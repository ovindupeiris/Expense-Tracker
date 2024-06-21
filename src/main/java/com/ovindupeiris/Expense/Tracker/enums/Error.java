package com.ovindupeiris.Expense.Tracker.enums;

import lombok.Getter;

@Getter
public enum Error {

    SUCCESS("000", "SUCCESS"),
    GENERAL_ERROR("002", "GENERAL ERROR"),
    NO_TRANSACTIONS_FOUND("005", "NO TRANSACTIONS FOUND"),
    USER_NOT_FOUND("006","USER NOT FOUND"),
    FAILED_TO_RETRIEVE_TRANSACTIONS("007", "FAILED TO RETRIEVE TRANSACTIONS");

    Error(String status, String description) {
        this.status = status;
        this.description = description;
    }

    private final String status;
    private final String description;
}
