package com.digital_exchange_agent.backend.dto;

import com.digital_exchange_agent.backend.entity.Sex;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.NonNull;

/*
- @NonNull -> checks if variable != null
- @NonEmpty -> checks if String != null and String != "" but sill whites spaces are allowed (String s = " ")
- @NotBlank -> checks if String != and String != ""; Only for String applicable!
 */
public record RecipientDTO(
        @NotBlank String name,
        @NotBlank String surname,
        @NonNull Sex sex,
        @NotBlank @Email String email,
        String phone_number) {
}
