package com.andrelangner.marvelapi.repository;

import com.andrelangner.marvelapi.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, Long> {
}
