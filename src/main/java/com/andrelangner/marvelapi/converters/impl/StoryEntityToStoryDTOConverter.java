package com.andrelangner.marvelapi.converters.impl;

import com.andrelangner.marvelapi.converters.api.IStoryEntityToStoryDTOConverter;
import com.andrelangner.marvelapi.dtos.StoryDTO;
import com.andrelangner.marvelapi.entities.StoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StoryEntityToStoryDTOConverter implements IStoryEntityToStoryDTOConverter {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public StoryDTO convert(StoryEntity entity) {
        StoryDTO result = modelMapper.map(entity, StoryDTO.class);
        result.setResourceURI("http://gateway.marvel.com/v1/public/stories/" + result.getId());
        return result;
    }
}
