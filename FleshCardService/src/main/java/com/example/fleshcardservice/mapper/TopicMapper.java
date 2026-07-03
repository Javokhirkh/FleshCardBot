package com.example.fleshcardservice.mapper;

import com.example.fleshcardservice.dtos.responses.TopicResponseDto;
import com.example.fleshcardservice.entities.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TopicMapper {

    @Mapping(source = "topicName", target = "topicName")
    TopicResponseDto toDto(Topic topic);
}
