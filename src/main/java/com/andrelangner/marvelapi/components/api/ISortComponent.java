package com.andrelangner.marvelapi.components.api;

import org.springframework.data.domain.Sort;

import java.util.List;

public interface ISortComponent {
    Sort get(Sort sort, String field);
    Sort get(List<String> sortList);
    void initDefault(List<String> orderBy, String defaultValue);
}
