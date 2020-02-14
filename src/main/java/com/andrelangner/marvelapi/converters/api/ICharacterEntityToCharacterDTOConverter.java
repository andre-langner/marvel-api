package com.andrelangner.marvelapi.converters.api;

import com.andrelangner.marvelapi.dtos.CharacterDTO;
import com.andrelangner.marvelapi.entities.CharacterEntity;

public interface ICharacterEntityToCharacterDTOConverter {
    CharacterDTO convert(CharacterEntity characterEntity);
}
