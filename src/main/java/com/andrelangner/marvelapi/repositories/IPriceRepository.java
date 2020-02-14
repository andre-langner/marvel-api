package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPriceRepository extends JpaRepository<PriceEntity, Long> {
}
