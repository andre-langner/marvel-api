package com.andrelangner.marvelapi.converters.api;

import com.andrelangner.marvelapi.dtos.SerieDTO;
import com.andrelangner.marvelapi.entities.SerieEntity;

public interface ISerieEntityToSerieDTOConverter {
    SerieDTO convert(SerieEntity entity);
}
