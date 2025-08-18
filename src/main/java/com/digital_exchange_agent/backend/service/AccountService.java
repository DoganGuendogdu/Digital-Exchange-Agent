package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.Account;
import com.digital_exchange_agent.backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getDefaultAccountForMVP() {
        final Integer accountID = 1;

        return accountRepository.findById(accountID);
    }
}
