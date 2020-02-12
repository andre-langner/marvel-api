package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.ComicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComicRepository extends JpaRepository<ComicEntity, Long> {
}
