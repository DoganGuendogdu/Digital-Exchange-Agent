package com.digital_exchange_agent.backend.controller;

import com.digital_exchange_agent.backend.dto.AccountDTO;
import com.digital_exchange_agent.backend.entity.Account;
import com.digital_exchange_agent.backend.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
    private final AccountService accountService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static Logger logger = LoggerFactory.getLogger(AccountController.class);

    public AccountController(AccountService accountService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.accountService = accountService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity<Account> createAccount(@RequestBody @Validated AccountDTO accountDTO) {
        logger.debug("Inserting Account into db");
        var account = new Account(
                accountDTO.name(),
                accountDTO.surname(),
                accountDTO.sex(),
                accountDTO.email(),
                bCryptPasswordEncoder.encode(accountDTO.password()),
                accountDTO.phoneNumber());
        logger.debug("Created Account '{}' from DTO: '{}'", account, accountDTO);

        try {
            logger.debug("Inserting Account into db.");
            var createdAccount = accountService.createAccount(account);
            var responseSuccess = new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
            logger.debug("Success. Returning '{}'.", responseSuccess);
            return responseSuccess;
        } catch (Exception e) {
            ResponseEntity<Account> responseFailure = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            logger.debug("Failed to save Account to database: {}", responseFailure);
            return responseFailure;
        }
    }
}
