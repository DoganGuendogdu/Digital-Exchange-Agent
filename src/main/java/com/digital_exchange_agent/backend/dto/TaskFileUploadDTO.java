package com.digital_exchange_agent.backend.dto;

import com.digital_exchange_agent.backend.entity.common.enums.FileType;
import com.digital_exchange_agent.backend.entity.common.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskFileUploadDTO(
        @NotNull byte[] file,
        @NotNull FileType fileType,
        String customInfo,
        @NotNull Status status,
        @NotNull int stepNumber,
        LocalDateTime uploadedAt,
        @NotBlank String fileName) {
}
