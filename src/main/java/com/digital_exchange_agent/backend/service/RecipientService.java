package com.digital_exchange_agent.backend.service;

import com.digital_exchange_agent.backend.entity.Recipient;
import com.digital_exchange_agent.backend.repository.RecipientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RecipientService {
    private final RecipientRepository recipientRepository;


    public RecipientService(RecipientRepository recipientRepository) {
        this.recipientRepository = recipientRepository;
    }

    public Recipient createRecipient(Recipient recipient) throws Exception {
        return recipientRepository.save(recipient);
    }

    public Optional<List<Recipient>> getRecipients() {
        return Optional.of(recipientRepository.findAll());
    }

    public Optional<Recipient> getDefaultRecipientForMVP() {
        final Integer recipientID = 1;

        return recipientRepository.findById(recipientID);
    }
}
