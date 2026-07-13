package com.example.fleshcardservice.dtos.responses;

import com.example.fleshcardservice.entities.Topic;
import com.example.fleshcardservice.enums.CefrLevel;

public record WordFullResponseDto (
        Long id,
        String text,
        String translation,
        String partOfSpeech,
        CefrLevel cefrLevel,
        String pronunciation,
        String definitionEng,
        TopicResponseDto topic
) {
}
