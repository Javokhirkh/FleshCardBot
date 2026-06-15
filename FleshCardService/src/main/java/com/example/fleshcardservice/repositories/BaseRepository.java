package com.example.fleshcardservice.repositories;

import com.example.fleshcardservice.entities.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, Long> {

    void trash(Long id);

    void trashAll(List<Long> ids);

    Optional<T> findByIdAndIsDeletedFalse(Long id);

    List<T> findAllByIsDeletedFalse();
    
    Page<T> findAllByIsDeletedFalse(Pageable pageable);

}
