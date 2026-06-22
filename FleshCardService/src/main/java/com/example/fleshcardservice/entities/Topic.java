package com.example.fleshcardservice.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Topic extends BaseEntity {

    @Column(name = "topic_name", nullable = false)
    private String topicName;

}
