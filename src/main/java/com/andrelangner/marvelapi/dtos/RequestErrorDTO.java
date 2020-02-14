package com.andrelangner.marvelapi.dtos;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RequestErrorDTO  implements Serializable {

    private Integer code;

    private String status;


}
