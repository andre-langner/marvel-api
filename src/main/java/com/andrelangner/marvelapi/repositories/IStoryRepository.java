package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoryRepository extends JpaRepository<StoryEntity, Long>, JpaSpecificationExecutor<StoryEntity> {
}
