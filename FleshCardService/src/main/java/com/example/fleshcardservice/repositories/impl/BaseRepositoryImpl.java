package com.example.fleshcardservice.repositories.impl;

import com.example.fleshcardservice.entities.BaseEntity;
import com.example.fleshcardservice.repositories.BaseRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.Optional;


public class BaseRepositoryImpl<T extends BaseEntity>
        extends SimpleJpaRepository<T, Long>
        implements BaseRepository<T> {


    private final Specification<T> isNotDeleted =
            (root, query, cb) -> cb.equal(root.get("isDeleted"), false);

    public BaseRepositoryImpl(JpaEntityInformation<T, Long> entityInformation,
                              EntityManager entityManager) {
        super(entityInformation, entityManager);
    }


    @Override
    @Transactional
    public void trash(Long id) {
        findById(id).ifPresent(entity -> {
            entity.setIsDeleted(true);
            save(entity);
        });
    }

    @Override
    @Transactional
    public void trashAll(List<Long> ids) {
        List<T> entities = findAllById(ids);
        entities.forEach(e -> e.setIsDeleted(true));
        saveAll(entities);
    }

    @Override
    public Optional<T> findByIdAndIsDeletedFalse(Long id) {
        return findById(id)
                .filter(entity -> !entity.getIsDeleted());
    }

    @Override
    public List<T> findAllByIsDeletedFalse() {
        return findAll(isNotDeleted);
    }

    @Override
    public Page<T> findAllByIsDeletedFalse(Pageable pageable) {
        return findAll(isNotDeleted, pageable);
    }


}