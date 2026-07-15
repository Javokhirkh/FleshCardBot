package com.example.fleshcardservice.services.impl;

import com.example.fleshcardservice.entities.User;
import com.example.fleshcardservice.entities.UserWord;
import com.example.fleshcardservice.entities.Word;
import com.example.fleshcardservice.enums.LearningStatus;
import com.example.fleshcardservice.repositories.UserWordRepository;
import com.example.fleshcardservice.services.UserWordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserWordServiceImp implements UserWordService {

    private final UserServiceImpl userService;
    private final WordServiceImpl wordService;
    private final UserWordRepository repository;

    @Override
    public void addWordToUser(Long wordId, Long userId) {
        User user = userService.getUserById(userId);
        Word word = wordService.getWordById(wordId);

        UserWord userWord = UserWord.builder()
                .user(user)
                .word(word)
                .build();

        repository.save(userWord);
    }

    @Override
    public void updateAfterReview(Long userWordId, int quality) {

    }

    @Override
    public List<UserWord> getWordsForReview(Long userId) {
        return List.of();
    }

    @Override
    public List<UserWord> getUserWordsByStatus(Long userId, LearningStatus status) {
        return List.of();
    }

    @Override
    public void deleteWordFromUser(Long wordId, Long userId) {

    }
}
