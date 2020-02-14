package com.andrelangner.marvelapi.services.impl;

import com.andrelangner.marvelapi.components.api.ISortComponent;
import com.andrelangner.marvelapi.components.api.IWhereComponent;
import com.andrelangner.marvelapi.converters.api.IEventEntityToEventDTOConverter;
import com.andrelangner.marvelapi.dtos.*;
import com.andrelangner.marvelapi.entities.EventEntity;
import com.andrelangner.marvelapi.repositories.IEventRepository;
import com.andrelangner.marvelapi.services.api.IEventService;
import com.andrelangner.marvelapi.specs.EventsSpecs;
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
public class EventService implements IEventService {

    @Autowired
    IEventRepository eventRepository;

    @Autowired
    IEventEntityToEventDTOConverter eventEntityToEventDTOConverter;

    @Autowired
    IWhereComponent whereComponent;

    @Autowired
    ISortComponent sortComponent;

    private Specification<EventEntity> getWhereForFindAll(EventParamsDTO params, Long characters){
        Specification<EventEntity> where = null;
        where = whereComponent.add(where, EventsSpecs.byCharacter(characters));
        return where;
    }

    @Override
    public DataContainerDTO<EventDTO> findAll(EventParamsDTO params, Long character) {
        int page = PageFunctions.getPageNumber(params.getOffset(), params.getLimit());

        sortComponent.initDefault(params.getOrderBy(), "title");

        Pageable pageable = PageRequest.of(page, params.getLimit(), sortComponent.get(params.getOrderBy()));

        Page<EventEntity> events = eventRepository.findAll(getWhereForFindAll(params, character), pageable);

        List<EventDTO> eventDTO = events.getContent().stream().map(
                    characterEntity -> eventEntityToEventDTOConverter.convert(characterEntity)
                ).collect(Collectors.toList());

        return DataContainerDTO.<EventDTO>builder()
                .count((long) eventDTO.size())
                .offset(params.getOffset())
                .limit(params.getLimit())
                .total(events.getTotalElements())
                .results(eventDTO)
                .build();
    }

    @Override
    public void getEvents(ResourceDTO<EventResourceDTO> dto, Long characterId) {
        EventParamsDTO eventParamsDTO = EventParamsDTO.builder()
                .offset(0)
                .limit(20)
                .build();

        DataContainerDTO<EventDTO> events = findAll(eventParamsDTO, characterId);

        dto.setAvailable(events.getTotal());
        dto.setCollectionURI("http://gateway.marvel.com/v1/public/characters/" + characterId + "/events");
        dto.setReturned(events.getCount());
        for (EventDTO eventDTO : events.getResults()) {
            dto.getItems().add(EventResourceDTO.builder()
                    .name(eventDTO.getTitle())
                    .resourceURI("http://gateway.marvel.com/v1/public/events/" + eventDTO.getId())
                    .build());
        }
    }
}
