package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
}
