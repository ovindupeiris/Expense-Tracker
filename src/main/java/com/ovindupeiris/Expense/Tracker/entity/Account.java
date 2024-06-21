package com.ovindupeiris.Expense.Tracker.entity;

import com.ovindupeiris.Expense.Tracker.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

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
    private String name;

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

    @CreatedDate
    @Column(name = "created_date")
    private Instant createdDate;

    @OneToOne(cascade = CascadeType.REFRESH, orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

}