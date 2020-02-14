package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "comics")
public class ComicEntity {

  @Id
  @Column(name = "comic_id")
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "serie_id")
  private SerieEntity serie;

  @JoinColumn(name = "digital_id")
  private Long digitalId;

  @Column(name = "title")
  private String title;

  @Column(name = "issue_number")
  private Long issueNumber;

  @Column(name = "variant_description")
  private String variantDescription;

  @Column(name = "description")
  private String description;

  @Column(name = "modified")
  private Date modified;

  @Column(name = "isbn")
  private String isbn;

  @Column(name = "upc")
  private String upc;

  @Column(name = "diamond_code")
  private String diamondCode;

  @Column(name = "ean")
  private String ean;

  @Column(name = "issn")
  private String issn;

  @Column(name = "format", length = 60)
  private String format;

  @Column(name = "page_count")
  private Long pageCount;

  @Column(name = "thumbnail_path")
  private String thumbnailPath;

  @Column(name = "thumbnail_extension", length = 3)
  private String thumbnailExtension;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "collections",
          joinColumns = @JoinColumn(name = "comic_id"),
          inverseJoinColumns = @JoinColumn(name = "collection_id"))
  private Set<ComicEntity> collections;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "issues",
          joinColumns = @JoinColumn(name = "comic_id"),
          inverseJoinColumns = @JoinColumn(name = "issue_id"))
  private Set<ComicEntity> issues;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "variants",
          joinColumns = @JoinColumn(name = "comic_id"),
          inverseJoinColumns = @JoinColumn(name = "variant_id"))
  private Set<ComicEntity> variants;

  @OneToMany(mappedBy = "comic", fetch = FetchType.LAZY)
  private Set<PriceEntity> prices;

  @OneToMany(mappedBy = "comic", fetch = FetchType.LAZY)
  private Set<DateEntity> dates;

  @OneToMany(mappedBy = "story", fetch = FetchType.LAZY)
  private Set<StoryComicEntity> stories;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
          name = "events_comics",
          joinColumns = @JoinColumn(name = "comic_id"),
          inverseJoinColumns = @JoinColumn(name = "event_id"))
  private Set<EventEntity> events;
}