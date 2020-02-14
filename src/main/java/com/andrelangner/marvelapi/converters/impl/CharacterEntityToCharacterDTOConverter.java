package com.andrelangner.marvelapi.converters.impl;

import com.andrelangner.marvelapi.converters.api.ICharacterEntityToCharacterDTOConverter;
import com.andrelangner.marvelapi.dtos.CharacterDTO;
import com.andrelangner.marvelapi.entities.CharacterEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CharacterEntityToCharacterDTOConverter implements ICharacterEntityToCharacterDTOConverter {

    @Autowired
    protected ModelMapper modelMapper;

    @Override
    public CharacterDTO convert(CharacterEntity characterEntity) {

        CharacterDTO result = modelMapper.map(characterEntity, CharacterDTO.class);
        result.setResourceURI("http://gateway.marvel.com/v1/public/characters/" + result.getId());
        return result;
    }
}
