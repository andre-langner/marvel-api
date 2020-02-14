package com.andrelangner.marvelapi.components.impl;

import com.andrelangner.marvelapi.components.api.IWhereComponent;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class WhereComponent implements IWhereComponent {

    @Override
    public <T> Specification<T> add(Specification<T> where, Specification<T> newClause) {
        if(where == null){
            return Specification.where(newClause);
        } else {
            return Specification.where(where).and(newClause);
        }
    }
}
