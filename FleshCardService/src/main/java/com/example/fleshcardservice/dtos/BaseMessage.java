package com.example.fleshcardservice.dtos;

public record BaseMessage(
        int code,
        String message
) implements Dto {
}
