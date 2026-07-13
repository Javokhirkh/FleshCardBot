package com.example.fleshcardservice.services.impl;

import com.example.fleshcardservice.dtos.requests.WordCreateDto;
import com.example.fleshcardservice.dtos.requests.WordUpdateRequestDto;
import com.example.fleshcardservice.dtos.responses.WordFullResponseDto;
import com.example.fleshcardservice.dtos.responses.WordShortResponseDto;
import com.example.fleshcardservice.entities.Word;
import com.example.fleshcardservice.exceptions.customs.UserNotFoundException;
import com.example.fleshcardservice.mapper.WordMapper;
import com.example.fleshcardservice.repositories.WordRepository;
import com.example.fleshcardservice.services.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

    private final WordRepository repository;
    private final WordMapper mapper;
    private final TopicServiceImpl topicService;

    @Override
    public void create(WordCreateDto dto) {
        Word word = Word.builder()
                .text(dto.text())
                .translation(dto.translation())
                .partOfSpeech(dto.partOfSpeech())
                .cefrLevel(dto.cefrLevel())
                .ipa(dto.ipa())
                .definitionEng(dto.definitionEng())
                .topic(topicService.getTopicById(dto.topicId())).build();

        repository.save(word);
    }

    @Override
    public void update(WordUpdateRequestDto dto) {
        Word word = findById(dto.id());
        word.setText(dto.text());
        word.setTranslation(dto.translation());
        word.setPartOfSpeech(dto.partOfSpeech());
        word.setCefrLevel(dto.cefrLevel());
        word.setIpa(dto.ipa());
        word.setDefinitionEng(dto.definitionEng());
        word.setTopic(topicService.getTopicById(dto.topicId()));
        repository.save(word);
    }

    @Override
    public WordFullResponseDto getById(Long id) {
        return mapper.toFullDto(findById(id));
    }

    @Override
    public List<WordShortResponseDto> getAll() {
        return repository.findAllByIsDeletedFalse()
                .stream()
                .map(mapper::toShortDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repository.trash(id);
    }

    private Word findById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
