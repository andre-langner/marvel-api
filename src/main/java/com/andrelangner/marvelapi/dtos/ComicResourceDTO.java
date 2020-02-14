package com.andrelangner.marvelapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComicResourceDTO {

    private String resourceURI;

    private String name;
}
