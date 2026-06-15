package com.example.fleshcardservice.entities;

import com.example.fleshcardservice.enums.CefrLevel;
import com.example.fleshcardservice.enums.PartOfSpeech;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Words extends BaseEntity {

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "translation", nullable = false)
    private String translation;

    @Column(name = "part_of_speech")
    @Enumerated(EnumType.STRING)
    private PartOfSpeech partOfSpeech;

    @Column(name = "cefr_level", nullable = false)
    @Enumerated(EnumType.STRING)
    private CefrLevel cefrLevel;

    private String ipa;  // pronunciation

    @Column(name = "definition_eng")
    private String definitionEng;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Topics topic;
}
