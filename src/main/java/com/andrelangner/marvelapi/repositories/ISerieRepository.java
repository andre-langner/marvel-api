package com.andrelangner.marvelapi.repositories;

import com.andrelangner.marvelapi.entities.SerieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ISerieRepository extends JpaRepository<SerieEntity, Long>, JpaSpecificationExecutor<SerieEntity> {
}
