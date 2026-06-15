package com.example.fleshcardservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Topics extends BaseEntity {

    @Column(name = "topic_name", nullable = false)
    private String topicName;

}
