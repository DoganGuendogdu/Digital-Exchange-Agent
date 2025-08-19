package com.digital_exchange_agent.backend.controller;

import com.digital_exchange_agent.backend.dto.TransactionDTO;
import com.digital_exchange_agent.backend.entity.Transactions;
import com.digital_exchange_agent.backend.service.*;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaction")
@Slf4j
public class TransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;
    private final RecipientService recipientService;

    private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(
            TransactionService transactionService,
            AccountService accountService,
            RecipientService recipientService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.recipientService = recipientService;
    }

    @PostMapping
    public ResponseEntity<Transactions> createTransaction(@RequestBody @Validated TransactionDTO transactionDTO) {
        var recipientOpt = recipientService.getRecipientById(transactionDTO.recipientId());
        var accountOpt = accountService.getAccountById(transactionDTO.accountId());

        logger.debug("Extracting recipient {} as Optional from TransactionDTO: {}",recipientOpt,  transactionDTO.recipientId());
        logger.debug("Extracting account {} as Optional from TransactionDTO: {}", accountOpt, transactionDTO.accountId());

        if (recipientOpt.isEmpty() || accountOpt.isEmpty()) {
            logger.error("Recipient or Account not found for TransactionDTO: {}", transactionDTO);
            return ResponseEntity.badRequest().build();
        }

        var recipient = recipientOpt.get();
        var account = accountOpt.get();

        logger.debug("Recipient found: {}", recipient);
        logger.debug("Account found: {}", account);

        var transaction = new Transactions(
                recipient,
                account,
                transactionDTO.topic(),
                transactionDTO.response(),
                transactionDTO.customInfo(),
                transactionDTO.tags(),
                transactionDTO.priorityLevel(),
                transactionDTO.status(),
                transactionDTO.createdAt()
        );
        logger.debug("Created Transaction {}", transaction);

        try {
            var createdTransaction = transactionService.createTransaction(transaction);
            logger.debug("Transaction created successfully: {}", createdTransaction);
            return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Failed to create transaction: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
