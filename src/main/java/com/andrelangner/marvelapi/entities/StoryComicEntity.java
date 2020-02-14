package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "stories_comics")
public class StoryComicEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "story_comic_id")
  private UUID id;

  @JoinColumn(name = "story_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private StoryEntity story;

  @JoinColumn(name = "comic_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private ComicEntity comic;

  @Column(name = "original")
  private Boolean original;
}
