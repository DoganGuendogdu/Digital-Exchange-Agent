package com.digital_exchange_agent.backend.dto;

import com.digital_exchange_agent.backend.entity.common.enums.FileType;
import com.digital_exchange_agent.backend.entity.common.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskFileUploadDTO(
        @NotNull(message = "Id of transaction can not be null") int transactionId,
        @NotNull(message = "File can not be null") byte[] file,
        @NotNull(message = "File type can not be null") FileType fileType,
        String customInfo,
        @NotNull(message = "Status can not be null") Status status,
        @NotNull(message = "Step number can not be null") int stepNumber,
        @NotBlank(message = "FIle name can not be null") String fileName,
        LocalDateTime uploadedAt) {
}
