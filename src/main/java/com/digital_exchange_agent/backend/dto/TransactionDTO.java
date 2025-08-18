package com.digital_exchange_agent.backend.dto;

import com.digital_exchange_agent.backend.entity.common.enums.PriorityLevel;
import com.digital_exchange_agent.backend.entity.common.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TransactionDTO(
        @NotNull(message = "Recipient can not be null") RecipientDTO recipientDTO,
        @NotNull(message = "Account can not be null") AccountDTO accountDTO,
        @NotNull(message = "Task can not be null") TaskDTO taskDTO,
        TaskFileUploadDTO taskFileUploadDTO,
        @NotBlank(message = "Topic can not be blank") String topic,
        String response,
        String customInfo,
        String tags,
        @NotNull(message = "Priority can not be null") PriorityLevel priorityLevel,
        @NotNull(message = "Status can not be null") Status status) {
}
