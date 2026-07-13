package com.example.fleshcardservice.services;

import com.example.fleshcardservice.dtos.requests.WordCreateDto;
import com.example.fleshcardservice.dtos.requests.WordUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.WordFullResponseDto;
import com.example.fleshcardservice.dtos.responses.WordShortResponseDto;

import java.util.List;

public interface WordService extends GenericService{

    void create(WordCreateDto dto);

    void update(WordUpdateRequestDto dto);

    WordFullResponseDto getById(Long id);

    List<WordShortResponseDto> getAll();

    void delete(Long id);
}
