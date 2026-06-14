package com.example.fleshcardservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "topic_name", nullable = false)
    private String topicName;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
