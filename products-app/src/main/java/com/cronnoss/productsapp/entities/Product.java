package com.cronnoss.productsapp.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table(name = "products")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "balance")
    private int balance;

    @Column(name = "type")
    private String type;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
