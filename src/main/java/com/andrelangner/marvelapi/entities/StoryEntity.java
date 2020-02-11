package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "stories")
public class StoryEntity {

  @Id
  @Column(name = "story_id")
  private Long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "type", length = 20)
  private String type;

  @Column(name = "modified")
  private Date modified;

  @Column(name = "start")
  private Date start;

  @Column(name = "end")
  private Date end;

  @Column(name = "thumbnail_path")
  private String thumbnailPath;

  @Column(name = "thumbnail_extension", length = 3)
  private String thumbnailExtension;

  @OneToMany(mappedBy = "comic")
  private Set<StoryComicEntity> comics;

  @OneToMany(mappedBy = "creator")
  private Set<CreatorStoryEntity> creators;
}
