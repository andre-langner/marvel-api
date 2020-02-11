package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<StoryEntity, Long> {
}
