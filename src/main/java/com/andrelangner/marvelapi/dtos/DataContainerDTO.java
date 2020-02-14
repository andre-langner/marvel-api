package com.andrelangner.marvelapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
public class DataContainerDTO<T> implements Serializable {

    private Integer offset;

    private Integer limit;

    private Long total;

    private Long count;

    private List<T> results;
}
