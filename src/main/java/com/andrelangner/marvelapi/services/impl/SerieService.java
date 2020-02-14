package com.andrelangner.marvelapi.services.impl;

import com.andrelangner.marvelapi.components.api.ISortComponent;
import com.andrelangner.marvelapi.components.api.IWhereComponent;
import com.andrelangner.marvelapi.converters.api.ISerieEntityToSerieDTOConverter;
import com.andrelangner.marvelapi.dtos.*;
import com.andrelangner.marvelapi.entities.SerieEntity;
import com.andrelangner.marvelapi.repositories.ISerieRepository;
import com.andrelangner.marvelapi.services.api.ISerieService;
import com.andrelangner.marvelapi.specs.SerieSpecs;
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
public class SerieService implements ISerieService {

    @Autowired
    ISerieRepository serieRepository;

    @Autowired
    ISerieEntityToSerieDTOConverter serieEntityToSerieDTOConverter;

    @Autowired
    IWhereComponent whereComponent;

    @Autowired
    ISortComponent sortComponent;

    private Specification<SerieEntity> getWhereForFindAll(SerieParamsDTO params, Long characters){
        Specification<SerieEntity> where = null;
        where = whereComponent.add(where, SerieSpecs.byCharacter(characters));
        return where;
    }

    @Override
    public DataContainerDTO<SerieDTO> findAll(SerieParamsDTO params, Long character) {
        int page = PageFunctions.getPageNumber(params.getOffset(), params.getLimit());

        sortComponent.initDefault(params.getOrderBy(), "title");

        Pageable pageable = PageRequest.of(page, params.getLimit(), sortComponent.get(params.getOrderBy()));

        Page<SerieEntity> series = serieRepository.findAll(getWhereForFindAll(params, character), pageable);

        List<SerieDTO> seriesDTO = series.getContent().stream().map(
                    characterEntity -> serieEntityToSerieDTOConverter.convert(characterEntity)
                ).collect(Collectors.toList());

        return DataContainerDTO.<SerieDTO>builder()
                .count((long) seriesDTO.size())
                .offset(params.getOffset())
                .limit(params.getLimit())
                .total(series.getTotalElements())
                .results(seriesDTO)
                .build();
    }

    @Override
    public void getSeries(ResourceDTO<SerieResourceDTO> dto, Long characterId) {
        SerieParamsDTO serieParamsDTO = SerieParamsDTO.builder()
                .offset(0)
                .limit(20)
                .build();

        DataContainerDTO<SerieDTO> series = findAll(serieParamsDTO, characterId);

        dto.setAvailable(series.getTotal());
        dto.setCollectionURI("http://gateway.marvel.com/v1/public/characters/" + characterId + "/series");
        dto.setReturned(series.getCount());
        for (SerieDTO serieDTO : series.getResults()) {
            dto.getItems().add(SerieResourceDTO.builder()
                    .name(serieDTO.getTitle())
                    .resourceURI("http://gateway.marvel.com/v1/public/series/" + serieDTO.getId())
                    .build());
        }
    }
}
