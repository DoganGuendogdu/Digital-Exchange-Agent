package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.Recipient;
import com.digital_exchange_agent.backend.repository.RecipientRepository;
import org.springframework.stereotype.Service;


@Service
public class RecipientService {
    private final RecipientRepository recipientRepository;


    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    public Recipient createRecipient(Recipient recipient) throws Exception {
        return recipientRepository.save(recipient);
    }
}
