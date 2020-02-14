package com.andrelangner.marvelapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceDTO<T> {
    private Long available;

    private String collectionURI;

    @Builder.Default
    private List<T> items = new ArrayList<>();

    private Long returned;
}
