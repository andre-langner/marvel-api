package com.andrelangner.marvelapi.specs;

import com.andrelangner.marvelapi.entities.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.SetJoin;
import java.util.Date;
import java.util.List;

public class CharacterSpecs {

    private static Boolean canExec(List<Long> list) {
        if (list == null) return false;

        return list.size() != 0;
    }

    public static Specification<CharacterEntity> byCharacter(Long characterId) {
        if (characterId == null)
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CharacterEntity_.id), characterId);
    }

    public static Specification<CharacterEntity> byName(String name) {
        if (name == null)
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(CharacterEntity_.name), name);
    }

    public static Specification<CharacterEntity> nameStartWith(String name) {
        if (name == null)
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(CharacterEntity_.name), name + "%");
    }

    public static Specification<CharacterEntity> modifiedSince(Date modifiedDate) {
        if (modifiedDate == null)
            return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(CharacterEntity_.modified), modifiedDate);
    }


    public static Specification<CharacterEntity> byComics(List<Long> comics) {
        if (!canExec(comics)) return null;

        return (root, query, cb) -> {
            query.distinct(true);

            SetJoin<CharacterEntity, StoryEntity> storyJoin = root.join(CharacterEntity_.stories);

            SetJoin<StoryEntity, StoryComicEntity> storyComicJoin = storyJoin.join(StoryEntity_.comics);

            Join<StoryComicEntity, ComicEntity> comicJoin = storyComicJoin.join(StoryComicEntity_.comic);

            return comicJoin.get(ComicEntity_.id).in(comics);
        };
    }

    public static Specification<CharacterEntity> bySeries(List<Long> series) {
        if (!canExec(series)) return null;

        return (root, query, cb) -> {

            query.distinct(true);

            SetJoin<CharacterEntity, StoryEntity> storyJoin = root.join(CharacterEntity_.stories);

            SetJoin<StoryEntity, StoryComicEntity> storyComicJoin = storyJoin.join(StoryEntity_.comics);

            Join<StoryComicEntity, ComicEntity> comicJoin = storyComicJoin.join(StoryComicEntity_.comic);

            Join<ComicEntity, SerieEntity> serieJoin = comicJoin.join(ComicEntity_.serie);

            return serieJoin.get(SerieEntity_.id).in(series);
        };
    }

    public static Specification<CharacterEntity> byEvents(List<Long> events) {
        if (!canExec(events)) return null;

        return (root, query, cb) -> {

            query.distinct(true);

            SetJoin<CharacterEntity, StoryEntity> storyJoin = root.join(CharacterEntity_.stories);

            SetJoin<StoryEntity, StoryComicEntity> storyComicJoin = storyJoin.join(StoryEntity_.comics);

            Join<StoryComicEntity, ComicEntity> comicJoin = storyComicJoin.join(StoryComicEntity_.comic);

            SetJoin<ComicEntity, EventEntity> eventJoin = comicJoin.join(ComicEntity_.events);

            return eventJoin.get(EventEntity_.id).in(events);
        };
    }

    public static Specification<CharacterEntity> byStories(List<Long> stories) {
        if (!canExec(stories)) return null;

        return (root, query, cb) -> {

            query.distinct(true);

            SetJoin<CharacterEntity, StoryEntity> storyJoin = root.join(CharacterEntity_.stories);

            return storyJoin.get(StoryEntity_.id).in(stories);
        };
    }
}
