package com.digital_exchange_agent.backend.entity;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, unique = true)
    private int id;

    @JoinColumn(name = "TRANSACTION_ID", nullable = false, unique = true)
    @ManyToOne
    private Transactions transaction;

    public Task() {
    }

    public Task(int id, Transactions transaction) {
        this.id = id;
        this.transaction = transaction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Transactions getTransaction() {
        return transaction;
    }

    public void setTransaction(Transactions transaction) {
        this.transaction = transaction;
    }
}
