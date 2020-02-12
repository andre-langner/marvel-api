package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "dates")
public class DateEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "date_id")
  private Long id;

  @ManyToOne
  @JoinColumn(name = "comic_id")
  private ComicEntity comic;

  @Column(name = "type", length = 30)
  private String type;

  @Column(name = "date")
  private Date date;
}
