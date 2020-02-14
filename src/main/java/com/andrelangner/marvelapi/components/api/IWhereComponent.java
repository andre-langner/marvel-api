package com.andrelangner.marvelapi.components.api;

import org.springframework.data.jpa.domain.Specification;

public interface IWhereComponent {
    <T> Specification<T> add(Specification<T> where, Specification<T> novaClausula);
}
