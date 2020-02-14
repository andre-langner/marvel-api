package com.andrelangner.marvelapi.services.impl;

import com.andrelangner.marvelapi.components.api.ISortComponent;
import com.andrelangner.marvelapi.components.api.IWhereComponent;
import com.andrelangner.marvelapi.converters.api.IStoryEntityToStoryDTOConverter;
import com.andrelangner.marvelapi.dtos.*;
import com.andrelangner.marvelapi.entities.StoryEntity;
import com.andrelangner.marvelapi.repositories.IStoryRepository;
import com.andrelangner.marvelapi.services.api.IStoryService;
import com.andrelangner.marvelapi.specs.StorySpecs;
import com.andrelangner.marvelapi.utils.PageFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoryService implements IStoryService {

    @Autowired
    IStoryRepository storyRepository;

    @Autowired
    IStoryEntityToStoryDTOConverter storyEntityToStoryDTOConverter;

    @Autowired
    IWhereComponent whereComponent;

    @Autowired
    ISortComponent sortComponent;

    private Specification<StoryEntity> getWhereForFindAll(StoryParamsDTO params, Long characters){
        Specification<StoryEntity> where = null;
        where = whereComponent.add(where, StorySpecs.byCharacter(characters));
        return where;
    }

    @Override
    public DataContainerDTO<StoryDTO> findAll(StoryParamsDTO params, Long character) {
        int page = PageFunctions.getPageNumber(params.getOffset(), params.getLimit());

        sortComponent.initDefault(params.getOrderBy(), "title");

        Pageable pageable = PageRequest.of(page, params.getLimit(), sortComponent.get(params.getOrderBy()));

        Page<StoryEntity> stories = storyRepository.findAll(getWhereForFindAll(params, character), pageable);

        List<StoryDTO> storiesDTO = stories.getContent().stream().map(
                characterEntity -> storyEntityToStoryDTOConverter.convert(characterEntity)
        ).collect(Collectors.toList());

        return DataContainerDTO.<StoryDTO>builder()
                .count((long) storiesDTO.size())
                .offset(params.getOffset())
                .limit(params.getLimit())
                .total(stories.getTotalElements())
                .results(storiesDTO)
                .build();
    }

    public void getStories(ResourceDTO<StoryResourceDTO> dto, Long characterId) {
        StoryParamsDTO serieParamsDTO = StoryParamsDTO.builder()
                .offset(0)
                .limit(20)
                .build();

        DataContainerDTO<StoryDTO> stories = findAll(serieParamsDTO, characterId);

        dto.setAvailable(stories.getTotal());
        dto.setCollectionURI("http://gateway.marvel.com/v1/public/characters/" + characterId + "/stories");
        dto.setReturned(stories.getCount());
        for (StoryDTO serieDTO : stories.getResults()) {
            dto.getItems().add(StoryResourceDTO.builder()
                    .name(serieDTO.getTitle())
                    .type(serieDTO.getType())
                    .resourceURI("http://gateway.marvel.com/v1/public/stories/" + serieDTO.getId())
                    .build());
        }
    }
}
