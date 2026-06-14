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
public class Words {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long wordId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "translation", nullable = false)
    private String translation;

    @Column(name = "part_of_speech")
    private PartOfSpeech partOfSpeech;

    @Column(name = "cefr_level", nullable = false)
    private CefrLevel cefrLevel;

    private String ipa;

    @Column(name = "definition_eng")
    private String definitionEng;

    @Builder.Default
    @Column(name = "is_active", nullable = false)
    private boolean isActive = true;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id")
    private  Topics topic;
}
