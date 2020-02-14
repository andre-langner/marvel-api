package com.andrelangner.marvelapi.converters.api;

import com.andrelangner.marvelapi.dtos.EventDTO;
import com.andrelangner.marvelapi.entities.EventEntity;

public interface IEventEntityToEventDTOConverter {
    EventDTO convert(EventEntity entity);
}
