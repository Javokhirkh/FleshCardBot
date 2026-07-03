package com.example.fleshcardservice.dtos.responses;

import lombok.Builder;

@Builder
public record TopicResponseDto (
        Long id,
        String topicName
) {
}
