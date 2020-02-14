package com.andrelangner.marvelapi.specs;

import com.andrelangner.marvelapi.entities.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.SetJoin;

public class SerieSpecs {

    public static Specification<SerieEntity> byCharacter(Long character) {
        if (character == null) return null;

        return (root, query, cb) -> {

            query.distinct(true);

            SetJoin<SerieEntity, ComicEntity> eventsJoin = root.join(SerieEntity_.comics);

            SetJoin<ComicEntity, StoryComicEntity> storyComicJoin = eventsJoin.join(ComicEntity_.stories);

            Join<StoryComicEntity, StoryEntity> storyJoin = storyComicJoin.join(StoryComicEntity_.story);

            SetJoin<StoryEntity, CharacterEntity> characterJoin = storyJoin.join(StoryEntity_.characters);

            return characterJoin.get(CharacterEntity_.id).in(character);
        };
    }

}