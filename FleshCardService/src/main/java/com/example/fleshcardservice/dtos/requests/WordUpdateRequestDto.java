package com.example.fleshcardservice.dtos.requests;

import com.example.fleshcardservice.enums.CefrLevel;
import com.example.fleshcardservice.enums.PartOfSpeech;

public record WordUpdateRequestDto (
        Long id,
        String text,
        String translation,
        PartOfSpeech partOfSpeech,
        CefrLevel cefrLevel,
        String ipa,
        String definitionEng,
        Long topicId
) {
}
