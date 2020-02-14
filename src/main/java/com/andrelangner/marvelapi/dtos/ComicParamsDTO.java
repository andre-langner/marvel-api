package com.andrelangner.marvelapi.dtos;

import com.andrelangner.marvelapi.constants.ErrorConstants;
import com.andrelangner.marvelapi.constants.RegexConstants;
import lombok.Builder;
import lombok.Data;
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
public class ComicParamsDTO implements Serializable {

    @Pattern(regexp = RegexConstants.comicFormats, message = ErrorConstants.INVALID_ORDER_PARAMETER)
    private String format;

    @Pattern(regexp = RegexConstants.comicFormatTypes, message = ErrorConstants.INVALID_ORDER_PARAMETER)
    private String formatType;

    @Pattern(regexp = RegexConstants.strBoolean, message = ErrorConstants.INVALID_ORDER_PARAMETER)
    private String noVariants;

    @Pattern(regexp = RegexConstants.dateDescriptor, message = ErrorConstants.INVALID_ORDER_PARAMETER)
    private String dateDescriptor;

    private List<String> dateRange;

    private String title;

    private String titleStartsWith;

    private Integer startYear;

    private Integer issueNumber;

    private String diamondCode;

    private Integer digitalId;

    private String upc;

    private String isbn;

    private String ean;

    private String issn;

    @Pattern(regexp = RegexConstants.strBoolean, message = ErrorConstants.INVALID_ORDER_PARAMETER)
    private String hasDigitalIssue;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date modifiedSince;

    @Builder.Default
    private List<Long> creators = new ArrayList<>();

    @Builder.Default
    private List<Long> series = new ArrayList<>();

    @Builder.Default
    private List<Long> events = new ArrayList<>();

    @Builder.Default
    private List<Long> stories = new ArrayList<>();

    @Builder.Default
    private List<Long> collaborators = new ArrayList<>();

    @Builder.Default
    private List<@Pattern(regexp = RegexConstants.comicOrderBy, message = ErrorConstants.INVALID_ORDER_PARAMETER) String> orderBy = new ArrayList<>();

    @Min(value = 1, message = ErrorConstants.LIMIT_INVALID_OR_BELOW_1)
    @Max(value = 100, message = ErrorConstants.LIMIT_GREATER_THAN_100)
    @Builder.Default
    private Integer limit = 20;

    @Builder.Default
    private Integer offset = 0;
}
