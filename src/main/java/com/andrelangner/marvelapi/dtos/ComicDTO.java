package com.andrelangner.marvelapi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComicDTO {
    private Long id;

    private Long digitalId;

    private String title;

    private Long issueNumber;

    private String variantDescription;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date modified;

    private String isb;

    private String upc;

    private String diamondCode;

    private String ean;

    private String issn;

    private String format;

    private String resourceURI;

    private ThumbnailDTO thumbnail;
}
