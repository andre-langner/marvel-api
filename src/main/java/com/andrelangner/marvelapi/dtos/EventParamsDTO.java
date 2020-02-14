package com.andrelangner.marvelapi.dtos;

import com.andrelangner.marvelapi.constants.ErrorConstants;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@Validated
@Builder
public class EventParamsDTO {

    @Builder.Default
    private List<@Pattern(regexp = "", message = ErrorConstants.INVALID_ORDER_PARAMETER) String> orderBy = new ArrayList<>();

    @Min(value = 1, message = ErrorConstants.LIMIT_INVALID_OR_BELOW_1)
    @Max(value = 100, message = ErrorConstants.LIMIT_GREATER_THAN_100)
    @Builder.Default
    private Integer limit = 20;

    @Builder.Default
    private Integer offset = 0;
}
