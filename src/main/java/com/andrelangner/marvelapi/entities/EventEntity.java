package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "events")
public class EventEntity {

  @Id
  @Column(name = "event_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "next_event_id")
  private EventEntity nextEventEntity;

  @OneToOne
  @JoinColumn(name = "previous_event_id")
  private EventEntity previousEventEntity;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

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

  @ManyToMany(mappedBy = "events")
  private Set<ComicEntity> comics;

  @OneToMany(mappedBy = "event")
  private Set<EventUrlEntity> urls;
}
