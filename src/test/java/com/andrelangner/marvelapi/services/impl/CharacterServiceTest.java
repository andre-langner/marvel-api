package com.andrelangner.marvelapi.services.impl;

import com.andrelangner.marvelapi.MarvelApiApplicationTests;
import com.andrelangner.marvelapi.dtos.CharacterDTO;
import com.andrelangner.marvelapi.dtos.CharacterParamsDTO;
import com.andrelangner.marvelapi.dtos.DataContainerDTO;
import com.andrelangner.marvelapi.services.api.ICharacterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

class CharacterServiceTest extends MarvelApiApplicationTests {

    @Autowired
    ICharacterService characterService;

    @Test
    void testFindByCharacter() {
        DataContainerDTO<CharacterDTO> characters = characterService.findAll(
                CharacterParamsDTO.builder().build(),
                1011334L
        );

        assertThat(characters.getCount()).isEqualTo(1);
        assertThat(characters.getResults().get(0).getId()).isEqualTo(1011334L);
        assertThat(characters.getResults().get(0).getName()).isEqualTo("3-D Man");
    }

    @Test
    void testFindAll() {
        DataContainerDTO<CharacterDTO> characters = characterService.findAll(
                CharacterParamsDTO.builder().build()
        );

        assertThat(characters.getCount()).isEqualTo(20);
        assertThat(characters.getResults().get(0).getId()).isEqualTo(1009644L);
        assertThat(characters.getResults().get(1).getId()).isEqualTo(1011042L);
        assertThat(characters.getResults().get(2).getId()).isEqualTo(1009646L);
        assertThat(characters.getResults().get(3).getId()).isEqualTo(1010753L);
        assertThat(characters.getResults().get(4).getId()).isEqualTo(1011395L);
    }

    @Test
    void testFindAllNoResults() {
        DataContainerDTO<CharacterDTO> characters = characterService.findAll(
                CharacterParamsDTO.builder().build(),
                999999999L
        );

        assertThat(characters.getCount()).isEqualTo(0);
    }
}