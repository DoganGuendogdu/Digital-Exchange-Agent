package com.digital_exchange_agent.backend.dto;

import jakarta.validation.constraints.NotNull;

public record TaskDTO(
        @NotNull(message = "transactionId can not be null") Integer transactionId) {
}
