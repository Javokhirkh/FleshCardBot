package com.example.fleshcardservice.services;

import com.example.fleshcardservice.entities.UserWord;
import com.example.fleshcardservice.enums.LearningStatus;

import java.util.List;

public interface UserWordService extends GenericService{

    void addWordToUser(Long wordId, Long userId);

    void updateAfterReview(Long userWordId, int quality);

    List<UserWord> getWordsForReview(Long userId);

    List<UserWord> getUserWordsByStatus(Long userId, LearningStatus status);

    void deleteWordFromUser(Long wordId, Long userId);
}
