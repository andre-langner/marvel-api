package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.CreatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorRepository extends JpaRepository<CreatorEntity, Long> {
}
