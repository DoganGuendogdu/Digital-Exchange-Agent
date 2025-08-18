package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.Transactions;
import com.digital_exchange_agent.backend.repository.TransactionRepository;
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

    public Optional<List<Transactions>> getTransactions() {
        return Optional.of(transactionRepository.findAll());
    }
}
