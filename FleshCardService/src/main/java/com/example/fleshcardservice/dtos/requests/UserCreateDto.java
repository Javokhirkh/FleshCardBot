package com.example.fleshcardservice.dtos.requests;

import com.example.fleshcardservice.dtos.Dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record UserCreateDto(
        @JsonProperty("chat_id")
        String chatId
) implements Dto {
}
