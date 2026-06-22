package com.example.fleshcardservice.entities;

import com.example.fleshcardservice.enums.LearningStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "user_words",
        uniqueConstraints = @UniqueConstraint(
                name = "uk_user_user_word",
                columnNames = {"user_id", "word_id"}
        )
)
public class UserWord extends BaseEntity {

    @Builder.Default
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private LearningStatus status = LearningStatus.NEW;

    @Builder.Default
    @Column(nullable = false)
    private int repetitions = 0;

    @Builder.Default
    @Column(name = "easiness_factor",nullable = false)
    private double easinessFactor = 2.50;

    @Builder.Default
    @Column(name = "interval_days",nullable = false)
    private int intervalDays = 0;


    @Column(name = "next_review_at")
    private LocalDate nextReviewAt ;

    @Builder.Default
    @Column(name = "times_reviewed", nullable = false)
    private int timesReviewed = 0;

    @Builder.Default
    @Column(name = "times_correct", nullable = false)
    private int timesCorrect = 0;

    @Builder.Default
    @Column(name = "times_wrong", nullable = false)
    private int timesWrong = 0;

    @Column(name = "last_reviewed_at")
    private LocalDateTime lastReviewedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    private Word word;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
