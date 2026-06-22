package com.example.fleshcardservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordExample extends BaseEntity {


    @Column(columnDefinition = "TEXT", nullable = false)
    private String sentence;

    @Column(columnDefinition = "TEXT")
    private String translation;

    @ManyToOne(fetch = FetchType.LAZY)
    private Word word;

}
