package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "creators")
public class CreatorStoryEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "creator_story_id")
  private UUID id;

  @JoinColumn(name = "story_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private StoryEntity story;

  @JoinColumn(name = "creator_id")
  @ManyToOne(fetch = FetchType.LAZY)
  private CreatorEntity creator;

  @Column(name = "role")
  private String role;
}
