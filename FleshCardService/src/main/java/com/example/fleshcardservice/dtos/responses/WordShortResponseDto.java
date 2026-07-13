package com.example.fleshcardservice.dtos.responses;

public record WordShortResponseDto (
        Long id,
        String text,
        String translation
) {
}
