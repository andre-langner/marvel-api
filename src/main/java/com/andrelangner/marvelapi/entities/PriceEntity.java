package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@Table(name = "prices")
public class PriceEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "price_id")
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "comic_id")
  private ComicEntity comic;

  @Column(name = "type", length = 30)
  private String type;

  @Column(name = "price")
  private BigDecimal price;
}
