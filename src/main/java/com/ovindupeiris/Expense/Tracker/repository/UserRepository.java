package com.ovindupeiris.Expense.Tracker.repository;

import com.ovindupeiris.Expense.Tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}