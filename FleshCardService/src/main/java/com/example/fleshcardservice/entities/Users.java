package com.example.fleshcardservice.entities;

import com.example.fleshcardservice.enums.CefrLevel;
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
public class Users extends BaseEntity {

    @Column(name = "chat_id", nullable = false)
    private String chatId;

    @Column(name = "current_level")
    @Enumerated(EnumType.STRING)
    private CefrLevel currentLevel;

    @Builder.Default
    @Column(name = "daily_goal",  nullable = false)
    private int dailyGoal = 20;

    @Builder.Default
    @Column(name = "daily_new_limit",  nullable = false)
    private int dailyNewLimit = 10;

    @Column(name = "reminder_time")
    private LocalDateTime reminderTime;

    @Builder.Default
    @Column(name = "streak_current", nullable = false)
    private int streakCurrent = 0;

    @Builder.Default
    @Column(name = "streak_longest", nullable = false)
    private int streakLongest = 0;

    @Column(name = "last_active_date")
    private LocalDate  lastActiveDate;
}
