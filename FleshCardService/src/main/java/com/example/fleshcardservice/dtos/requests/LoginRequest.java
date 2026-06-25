package com.example.fleshcardservice.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record LoginRequest (
        @NotNull
        @JsonProperty("user_name")
        String userName,

        @NotNull
        String password
) {
}
