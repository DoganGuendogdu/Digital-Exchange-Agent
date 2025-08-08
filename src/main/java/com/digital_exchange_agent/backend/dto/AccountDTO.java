package com.digital_exchange_agent.backend.dto;

import com.digital_exchange_agent.backend.entity.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;

public record AccountDTO(
        @NotBlank @Length(max = 255) String name,
        @NotBlank @Length(max = 255) String surname,
        @NonNull Sex sex,
        @NotBlank @Email @Length(max = 255) String email,
        @NotBlank @Length(max = 40) String password,
        @NotBlank @Length(max = 25) String phoneNumber){
}
