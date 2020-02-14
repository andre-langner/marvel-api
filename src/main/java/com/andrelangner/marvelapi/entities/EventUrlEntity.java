package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "series_urls")
public class EventUrlEntity {

  @Id
  @Column(name = "event_url_id")
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "event_id")
  private EventEntity event;

  @Column(name = "type", length = 30)
  private String type;

  @Column(name = "url")
  private String url;

}
