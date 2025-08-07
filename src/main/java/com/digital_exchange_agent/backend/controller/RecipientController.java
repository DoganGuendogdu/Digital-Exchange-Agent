package com.digital_exchange_agent.backend.controller;

import com.digital_exchange_agent.backend.dto.RecipientDTO;
import com.digital_exchange_agent.backend.entity.Recipient;
import com.digital_exchange_agent.backend.service.RecipientService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipient")
@Slf4j
public class RecipientController {
    private final RecipientService recipientService;
    private final static Logger logger = LoggerFactory.getLogger(RecipientController.class);

    public RecipientController(RecipientService recipientService) {
        this.recipientService = recipientService;
    }

    @PostMapping()
    public ResponseEntity<Recipient> createRecipient(@RequestBody @Validated RecipientDTO recipientDTO) {
        logger.debug("Inserting Recipient into db.");
        var recipient = new Recipient(
                recipientDTO.name(),
                recipientDTO.surname(),
                recipientDTO.sex(),
                recipientDTO.email(),
                recipientDTO.phone_number()
        );
        logger.debug("Created Recipient '{}' from DTO: '{}'.", recipient, recipientDTO);

        try {
            logger.debug("Inserting Recipient into db.");
            var createRecipient = recipientService.createRecipient(recipient);
            var returnSuccess = new ResponseEntity<>(createRecipient, HttpStatus.CREATED);
            logger.debug("Success. Returning '{}'.", returnSuccess);
            logger.debug("{}", returnSuccess);
            return returnSuccess;
        } catch (Exception e) {
            logger.debug("Failed to save Recipient to database");
            ResponseEntity<Recipient> returnFailure = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            logger.error("Failure. Returning '{}'.", returnFailure);
            return returnFailure;
        }
    }
}
