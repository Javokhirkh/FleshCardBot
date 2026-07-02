package com.example.fleshcardservice.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserShortResponseDto(
        Long id,
        @JsonProperty("user_name")
        String userName
)  {
}
