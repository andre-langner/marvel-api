package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "series")
public class SerieEntity {

  @Id
  @Column(name = "serie_id")
  private Long id;

  @OneToOne
  @JoinColumn(name = "next_serie_id")
  private SerieEntity nextSerieEntity;

  @OneToOne
  @JoinColumn(name = "previous_serie_id")
  private SerieEntity previousSerieEntity;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "start_year")
  private Long startYear;

  @Column(name = "end_year")
  private Long endYear;

  @Column(name = "rating")
  private Long rating;

  @Column(name = "modified")
  private Date modified;

  @Column(name = "thumbnail_path")
  private String thumbnailPath;

  @Column(name = "thumbnail_extension", length = 3)
  private String thumbnailExtension;
}
