package com.andrelangner.marvelapi.services.api;

import com.andrelangner.marvelapi.dtos.*;

public interface ISerieService {

    DataContainerDTO<SerieDTO> findAll(SerieParamsDTO params, Long character);
    void getSeries(ResourceDTO<SerieResourceDTO> dto, Long characterId);

}
