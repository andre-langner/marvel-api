package com.andrelangner.marvelapi.dtos;

import com.andrelangner.marvelapi.constants.ErrorConstants;
import com.andrelangner.marvelapi.constants.RegexConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Validated
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterParamsDTO implements Serializable {

    private String name;

    private String nameStartsWith;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date modifiedSince;

    @Builder.Default
    private List<Long> comics = new ArrayList<>();

    @Builder.Default
    private List<Long> series = new ArrayList<>();

    @Builder.Default
    private List<Long> events = new ArrayList<>();

    @Builder.Default
    private List<Long> stories = new ArrayList<>();

    @Builder.Default
    private List<@Pattern(regexp = RegexConstants.characterOrderBy, message = ErrorConstants.INVALID_ORDER_PARAMETER) String> orderBy = new ArrayList<>();

    @Min(value = 1, message = ErrorConstants.LIMIT_INVALID_OR_BELOW_1)
    @Max(value = 100, message = ErrorConstants.LIMIT_GREATER_THAN_100)
    @Builder.Default
    private Integer limit = 20;

    @Builder.Default
    private Integer offset = 0;
}
