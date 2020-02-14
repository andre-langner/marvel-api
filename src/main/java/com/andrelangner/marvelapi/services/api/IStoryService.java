package com.andrelangner.marvelapi.services.api;

import com.andrelangner.marvelapi.dtos.*;

public interface IStoryService {

    DataContainerDTO<StoryDTO> findAll(StoryParamsDTO params, Long character);
    void getStories(ResourceDTO<StoryResourceDTO> dto, Long characterId);

}
