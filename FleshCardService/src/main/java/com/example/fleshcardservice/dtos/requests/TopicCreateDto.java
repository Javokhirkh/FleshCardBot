package com.example.fleshcardservice.dtos.requests;

import jakarta.validation.constraints.NotNull;

public record TopicCreateDto (
        @NotNull
        String topicName
) {
}
