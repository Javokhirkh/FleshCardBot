package com.example.fleshcardservice.services.impl;

import com.example.fleshcardservice.dtos.requests.TopicCreateDto;
import com.example.fleshcardservice.dtos.requests.TopicUpdateDto;
import com.example.fleshcardservice.dtos.responses.TopicResponseDto;
import com.example.fleshcardservice.entities.Topic;
import com.example.fleshcardservice.exceptions.customs.UserNotFoundException;
import com.example.fleshcardservice.mapper.TopicMapper;
import com.example.fleshcardservice.repositories.TopicRepository;
import com.example.fleshcardservice.services.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicServiceImpl implements TopicService {

    private final TopicRepository repository;
    private final TopicMapper mapper;

    @Override
    public void createTopic(TopicCreateDto dto) {
        Topic topic = Topic.builder()
                .topicName(dto.topicName())
                .build();
        repository.save(topic);
    }

    @Override
    public void update(TopicUpdateDto dto) {
        Topic topic = getTopicById(dto.id());
        topic.setTopicName(dto.topicName());
        repository.save(topic);
    }

    @Override
    public TopicResponseDto getById(Long id) {
        return mapper.toDto(getTopicById(id));
    }

    @Override
    public List<TopicResponseDto> getAll() {
        return repository.findAllByIsDeletedFalse()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private Topic getTopicById(Long id) {
        return repository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
