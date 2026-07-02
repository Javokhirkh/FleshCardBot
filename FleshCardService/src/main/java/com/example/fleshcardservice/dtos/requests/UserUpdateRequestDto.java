package com.example.fleshcardservice.dtos.requests;

import jakarta.validation.constraints.NotNull;

public record UserUpdateRequestDto(
        @NotNull
        Long id,
        String password
) {
}
