package com.example.fleshcardservice.dtos.responses;

import com.example.fleshcardservice.enums.CefrLevel;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
public record UserFullResponseDto(
        Long id,
        String userName,
        CefrLevel currentLevel,
        int dailyGoal,
        int dailyNewLimit,
        LocalDateTime reminderTime,
        int streakCurrent,
        int streakLongest,
        LocalDate lastActiveDate
) {
}