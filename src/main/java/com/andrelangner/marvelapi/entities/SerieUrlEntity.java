package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "series_urls")
public class SerieUrlEntity {

  @Id
  @Column(name = "serie_url_id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "serie_id")
  private SerieEntity serie;

  @Column(name = "type", length = 30)
  private String type;

  @Column(name = "url")
  private String url;

}
