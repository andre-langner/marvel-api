package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreatorRepository extends JpaRepository<CreatorEntity, Long> {
}
