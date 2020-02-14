package com.andrelangner.marvelapi.components.impl;

import com.andrelangner.marvelapi.components.api.ISortComponent;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortComponent implements ISortComponent {
    @Override
    public Sort get(Sort sort, String field) {
        final String descendingIndicator = "-";
        Sort newSort = (field.startsWith(descendingIndicator)) ?
                Sort.by(StringUtils.removeStart(field, descendingIndicator)).descending() :
                Sort.by(field).ascending();

        if (sort != null) {
            return sort.and(newSort);
        }

        return newSort;
    }

    @Override
    public Sort get(List<String> sortList) {
        Sort sort = null;

        for (String item : sortList) {
            sort = this.get(sort, item);
        }

        return sort;
    }

    @Override
    public void initDefault(List<String> orderBy, String defaultValue) {
        if (orderBy.size() == 0) orderBy.add(defaultValue);
    }
}
