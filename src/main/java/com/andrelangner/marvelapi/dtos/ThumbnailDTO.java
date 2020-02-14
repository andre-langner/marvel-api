package com.andrelangner.marvelapi.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThumbnailDTO implements Serializable {

    private String path;

    private String extension;
}
