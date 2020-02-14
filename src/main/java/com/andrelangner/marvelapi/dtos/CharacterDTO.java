package com.andrelangner.marvelapi.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDTO implements Serializable {

    private Long id;

    private String name;

    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private Date modified;

    private String resourceURI;

    private ThumbnailDTO thumbnail;

    @Builder.Default
    private ResourceDTO<ComicResourceDTO> comics = new ResourceDTO<>();

    @Builder.Default
    private ResourceDTO<SerieResourceDTO> series = new ResourceDTO<>();

    @Builder.Default
    private ResourceDTO<StoryResourceDTO> stories = new ResourceDTO<>();

    @Builder.Default
    private ResourceDTO<EventResourceDTO> events = new ResourceDTO<>();

    @Builder.Default
    private List<String> urls = new ArrayList<>();
}
