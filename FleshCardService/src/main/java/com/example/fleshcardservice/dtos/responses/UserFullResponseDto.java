package com.example.fleshcardservice.dtos.responses;

import lombok.Builder;

@Builder
public record UserFullResponseDto(
        Long id,
        String chatId
) {
}