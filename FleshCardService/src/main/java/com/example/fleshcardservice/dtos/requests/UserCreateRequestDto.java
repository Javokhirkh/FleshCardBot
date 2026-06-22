package com.example.fleshcardservice.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserCreateRequestDto(
        @JsonProperty("chat_id")
        String chatId
){
}
