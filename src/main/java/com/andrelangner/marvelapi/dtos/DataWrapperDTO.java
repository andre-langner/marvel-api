package com.andrelangner.marvelapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class DataWrapperDTO <T> implements Serializable {

    private final Integer code = 200;

    private final String status = "OK";

    private final String copyright = "© 2020 MARVEL";

    private final String attributionText = "Data provided by Marvel. © 2020 MARVEL";

    private final String attributionHTML = "<a href=\"http://marvel.com\">Data provided by Marvel. © 2020 MARVEL</a>";

    private final String etag = "25f588658a8e4c9694f57e51369df9c1792821bb";

    private DataContainerDTO<T> data;
}
