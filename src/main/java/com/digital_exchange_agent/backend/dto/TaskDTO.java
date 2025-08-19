package com.digital_exchange_agent.backend.dto;

import jakarta.validation.constraints.NotNull;

public record TaskDTO(
        @NotNull(message = "Id of transaction can not be null") int transactionId) {
}
