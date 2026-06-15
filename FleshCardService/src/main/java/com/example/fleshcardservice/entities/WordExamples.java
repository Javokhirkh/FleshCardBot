package com.example.fleshcardservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordExamples extends BaseEntity {


    @Column(nullable = false)
    private String sentence;

    private String translation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Words words;

}
