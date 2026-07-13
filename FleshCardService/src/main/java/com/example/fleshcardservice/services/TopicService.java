package com.example.fleshcardservice.services;

import com.example.fleshcardservice.dtos.requests.TopicCreateDto;
import com.example.fleshcardservice.dtos.requests.TopicUpdateDto;
import com.example.fleshcardservice.dtos.responses.TopicResponseDto;

import java.util.List;

public interface TopicService extends GenericService{

    void  create(TopicCreateDto dto);

    void update(TopicUpdateDto dto);

    TopicResponseDto getById(Long id);

    List<TopicResponseDto> getAll();

    void delete(Long id);
}
