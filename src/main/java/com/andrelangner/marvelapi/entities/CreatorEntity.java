package com.andrelangner.marvelapi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "creators")
public class CreatorEntity {

  @Id
  @Column(name = "creator_id")
  private Long id;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "suffix", length = 30)
  private String suffix;

  @Column(name = "modified")
  private Date modified;

  @Column(name = "thumbnail_path")
  private String thumbnailPath;

  @Column(name = "thumbnail_extension", length = 3)
  private String thumbnailExtension;

  @OneToMany(mappedBy = "story")
  private Set<CreatorStoryEntity> stories;
}
