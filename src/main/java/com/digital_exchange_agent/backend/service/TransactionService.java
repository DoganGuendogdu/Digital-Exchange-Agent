package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.Transactions;
import com.digital_exchange_agent.backend.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transactions createTransaction(Transactions transaction) {
        return transactionRepository.save(transaction);
    }

    public Optional<Transactions> getTransactionById(Integer id) {
        return transactionRepository.findById(id).or(() -> {
            throw new EntityNotFoundException("Transaction with id " + id + " not found");
        });
    }

    public Optional<List<Transactions>> getTransactions() {
        return Optional.of(transactionRepository.findAll());
    }
}
