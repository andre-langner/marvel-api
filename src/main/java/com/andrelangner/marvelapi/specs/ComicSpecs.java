package com.andrelangner.marvelapi.specs;

import com.andrelangner.marvelapi.entities.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.SetJoin;

public class ComicSpecs {

    public static Specification<ComicEntity> byCharacter(Long character) {
        if (character == null) return null;

        return (root, query, cb) -> {

            query.distinct(true);

            SetJoin<ComicEntity, StoryComicEntity> storyComicJoin = root.join(ComicEntity_.stories);

            Join<StoryComicEntity, StoryEntity> storyJoin = storyComicJoin.join(StoryComicEntity_.story);

            SetJoin<StoryEntity, CharacterEntity> characterJoin = storyJoin.join(StoryEntity_.characters);

            return characterJoin.get(CharacterEntity_.id).in(character);
        };
    }

}