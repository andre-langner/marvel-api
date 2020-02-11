package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SerieRepository extends JpaRepository<SerieEntity, Long> {
}
