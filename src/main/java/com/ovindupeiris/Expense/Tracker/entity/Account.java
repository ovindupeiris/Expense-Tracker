package com.ovindupeiris.Expense.Tracker.entity;

import com.ovindupeiris.Expense.Tracker.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @NotBlank(message = "Account name cannot be empty")
    @Column(name = "name", nullable = false)
    private Long name;

    @NotNull
    @NotBlank(message = "Account type invalid")
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AccountType type;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @NotNull
    @NotBlank(message = "Currency cannot be empty")
    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(cascade = CascadeType.REFRESH, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

}