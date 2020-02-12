package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, Long> {
}
