package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
}
