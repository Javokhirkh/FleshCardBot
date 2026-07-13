package com.example.fleshcardservice.mapper;

import com.example.fleshcardservice.dtos.responses.WordFullResponseDto;
import com.example.fleshcardservice.dtos.responses.WordShortResponseDto;
import com.example.fleshcardservice.entities.Word;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WordMapper {

    WordShortResponseDto toShortDto(Word word);

    WordFullResponseDto toFullDto(Word word);
}
