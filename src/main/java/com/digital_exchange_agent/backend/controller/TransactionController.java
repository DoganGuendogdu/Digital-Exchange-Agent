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
            RecipientService recipientService,
            TaskService taskService,
            TaskFIleUploadService taskFIleUploadService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
        this.recipientService = recipientService;
        this.taskService = taskService;
        this.taskFIleUploadService = taskFIleUploadService;
    }

    @PostMapping
    public ResponseEntity<Transactions> createTransactionForMVP() {
        var defaultRecipient = recipientService.getDefaultRecipientForMVP();
        var defaultAccount = accountService.getDefaultAccountForMVP();

        if (defaultRecipient.isPresent() && defaultAccount.isPresent()) {
            var transactionDefault = new Transactions(
                    defaultRecipient.get(),
                    defaultAccount.get(),
                    "Test topic",
                    "balabalab response",
                    "blababa custom info",
                    "blababa tags",
                    PriorityLevel.LOW,
                    Status.IN_PROGRESS,
                    LocalDateTime.now()
            );

            try {
                transactionService.createTransaction(transactionDefault);
            } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.badRequest().body(null);
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Transactions>> getTransactions() {
        var transactionListOptional = transactionService.getTransactions();

        try{
            if (transactionListOptional.isPresent())
                return ResponseEntity.ok(transactionListOptional.get());
            return ResponseEntity.notFound().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
