package com.example.fleshcardservice.dtos.requests;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UserUpdateRequestDto(
        @NotNull
        Long id,
        String userName,
        String password,
        Integer dailyGoal,
        Integer dailyNewLimit,
        LocalDateTime reminderTime
) {
}
