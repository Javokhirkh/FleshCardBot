package com.example.fleshcardservice.dtos.requests;

import com.example.fleshcardservice.enums.CefrLevel;
import com.example.fleshcardservice.enums.PartOfSpeech;
import lombok.Builder;

@Builder
public record WordCreateDto (
        String text,
        String translation,
        PartOfSpeech partOfSpeech,
        CefrLevel cefrLevel,
        String ipa,
        String definitionEng,
        Long topicId
) {
}
