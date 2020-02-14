package com.andrelangner.marvelapi.converters.impl;

import com.andrelangner.marvelapi.converters.api.IEventEntityToEventDTOConverter;
import com.andrelangner.marvelapi.dtos.EventDTO;
import com.andrelangner.marvelapi.entities.EventEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventEntityToEventDTOConverter implements IEventEntityToEventDTOConverter {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public EventDTO convert(EventEntity entity) {
        EventDTO result = modelMapper.map(entity, EventDTO.class);
        result.setResourceURI("http://gateway.marvel.com/v1/public/events/" + result.getId());
        return result;
    }
}
