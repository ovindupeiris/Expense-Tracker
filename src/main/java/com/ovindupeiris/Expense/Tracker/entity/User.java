package com.ovindupeiris.Expense.Tracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Min(value = 5, message = "Username should be longer than 5 characters")
    @Column(name = "username", nullable = false)
    private String username;

    @Email(message = "Email invalid")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @CreatedDate
    @Column(name = "created_date")
    private Instant createdDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

}