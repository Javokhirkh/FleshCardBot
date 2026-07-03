package com.example.fleshcardservice.dtos.requests;

import jakarta.validation.constraints.NotNull;

public record TopicUpdateDto (
        @NotNull
        Long id,
        @NotNull
        String topicName
) {
}
