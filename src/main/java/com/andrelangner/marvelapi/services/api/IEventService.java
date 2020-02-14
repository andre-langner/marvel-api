package com.andrelangner.marvelapi.services.api;

import com.andrelangner.marvelapi.dtos.*;

public interface IEventService {

    DataContainerDTO<EventDTO> findAll(EventParamsDTO params, Long character);
    void getEvents(ResourceDTO<EventResourceDTO> dto, Long characterId);
}
