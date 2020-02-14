package com.andrelangner.marvelapi.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum CharacterParamsOrderEnum {
    NAME_ASC("name"),
    NAME_DESC("-name"),
    MODIFIED_ASC("modified"),
    MODIFIED_DESC("-modified");

    @Getter
    private final String flag;
}
