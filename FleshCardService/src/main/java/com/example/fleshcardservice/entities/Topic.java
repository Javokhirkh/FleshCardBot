package com.example.fleshcardservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "topic")
public class Topic extends BaseEntity {

    @Column(name = "topic_name", nullable = false, unique = true)
    private String topicName;

}
