package com.andrelangner.marvelapi.services.api;

import com.andrelangner.marvelapi.dtos.CharacterDTO;
import com.andrelangner.marvelapi.dtos.CharacterParamsDTO;
import com.andrelangner.marvelapi.dtos.DataContainerDTO;

public interface ICharacterService {

    DataContainerDTO<CharacterDTO> findAll(CharacterParamsDTO params);
    DataContainerDTO<CharacterDTO> findAll(CharacterParamsDTO params, Long character);

}
