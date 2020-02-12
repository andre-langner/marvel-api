package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.SerieUrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SerieUrlRepository extends JpaRepository<SerieUrlEntity, UUID> {
}
