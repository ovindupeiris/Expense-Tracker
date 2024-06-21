package com.ovindupeiris.Expense.Tracker.enums;

import lombok.Getter;

@Getter
public enum Error {

    SUCCESS("000","SUCCESS"),
    GENERAL_ERROR("002","GENERAL ERROR");

    Error(String status, String description) {
        this.status = status;
        this.description = description;
    }

    private final String status;
    private final String description;
}
