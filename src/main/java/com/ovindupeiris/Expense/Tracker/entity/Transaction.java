package com.ovindupeiris.Expense.Tracker.entity;

import com.ovindupeiris.Expense.Tracker.enums.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @NotBlank(message = "Transaction type invalid")
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TransactionType type;

    @NotNull
    @NotBlank(message = "Category cannot be empty")
    @Column(name = "category", nullable = false)
    private String category;

    @NotNull
    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "account_id")
    private Account account;

    @Value("${some.key:false}")
    @Column(name = "recurring", nullable = false)
    private Boolean recurring;

    @Column(name = "status", nullable = false)
    private String status;

    @NotNull
    @NotBlank(message = "Transaction date cannot be empty")
    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @CreatedDate
    @Column(name = "created_date")
    private Instant createdDate;

}