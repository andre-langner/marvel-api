package com.andrelangner.marvelapi.converters.impl;

import com.andrelangner.marvelapi.converters.api.ISerieEntityToSerieDTOConverter;
import com.andrelangner.marvelapi.dtos.SerieDTO;
import com.andrelangner.marvelapi.entities.SerieEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SerieEntityToSerieDTOConverter implements ISerieEntityToSerieDTOConverter {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public SerieDTO convert(SerieEntity entity) {
        SerieDTO result = modelMapper.map(entity, SerieDTO.class);
        result.setResourceURI("http://gateway.marvel.com/v1/public/series/" + result.getId());
        return result;
    }
}
