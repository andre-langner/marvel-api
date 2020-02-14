package com.andrelangner.marvelapi.converters.api;

import com.andrelangner.marvelapi.dtos.StoryDTO;
import com.andrelangner.marvelapi.entities.StoryEntity;

public interface IStoryEntityToStoryDTOConverter {
    StoryDTO convert(StoryEntity entity);
}
