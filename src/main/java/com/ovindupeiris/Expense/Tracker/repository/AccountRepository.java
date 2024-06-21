package com.ovindupeiris.Expense.Tracker.repository;

import com.ovindupeiris.Expense.Tracker.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}