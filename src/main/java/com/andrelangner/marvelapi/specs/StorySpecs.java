package com.andrelangner.marvelapi.specs;

import com.andrelangner.marvelapi.entities.CharacterEntity;
import com.andrelangner.marvelapi.entities.CharacterEntity_;
import com.andrelangner.marvelapi.entities.StoryEntity;
import com.andrelangner.marvelapi.entities.StoryEntity_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.SetJoin;

public class StorySpecs {

    public static Specification<StoryEntity> byCharacter(Long character) {
        if (character == null) return null;

        return (root, query, cb) -> {

            query.distinct(true);

            SetJoin<StoryEntity, CharacterEntity> characterJoin = root.join(StoryEntity_.characters);

            return characterJoin.get(CharacterEntity_.id).in(character);
        };
    }

}