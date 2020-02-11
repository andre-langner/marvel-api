package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.ComicEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicRepository extends JpaRepository<ComicEntity, Long> {
}
