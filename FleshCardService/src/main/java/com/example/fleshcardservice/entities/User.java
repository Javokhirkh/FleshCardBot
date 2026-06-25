package com.example.fleshcardservice.entities;

import com.example.fleshcardservice.enums.CefrLevel;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity implements UserDetails {

//    @Column(name = "chat_id", nullable = false)
//    private String chatId;

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

    @Column(name = "user_name", unique = true,  nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
