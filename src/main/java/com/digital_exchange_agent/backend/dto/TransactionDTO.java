package com.digital_exchange_agent.backend.dto;

import com.digital_exchange_agent.backend.entity.common.enums.PriorityLevel;
import com.digital_exchange_agent.backend.entity.common.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record TransactionDTO(
        @NotNull(message = "Id of Recipient can not be null") int recipientId,
        @NotNull(message = "Id of Account can not be null")  int accountId,
        @NotBlank(message = "Topic can not be blank") String topic,
        String response,
        String customInfo,
        String tags,
        @NotNull(message = "Priority can not be null") PriorityLevel priorityLevel,
        @NotNull(message = "Status can not be null") Status status,
        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @NotNull(message = "CreatedAt can ne null")LocalDateTime createdAt) {
    }
