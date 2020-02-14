package com.andrelangner.marvelapi.handlers;

import com.andrelangner.marvelapi.dtos.RequestErrorDTO;
import com.andrelangner.marvelapi.constants.ErrorConstants;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Order(1)
public class RestResponseEntityExceptionHandler {

    private ResponseEntity<RequestErrorDTO> getResponse(FieldError fieldError){
        String message = fieldError == null ? ErrorConstants.INVALID_PARAMETER : fieldError.getDefaultMessage();

        return getResponse(message);
    }

    private ResponseEntity<RequestErrorDTO> getResponse(String message){
        final HttpStatus status = HttpStatus.CONFLICT;

        RequestErrorDTO errorResponse = RequestErrorDTO.builder()
                .code(status.value())
                .status(message)
                .build();

        return new ResponseEntity<>(errorResponse, status);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<RequestErrorDTO> handleConflict(MethodArgumentNotValidException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().stream().findFirst().orElse(null);

        return getResponse(fieldError);
    }

    @ExceptionHandler({BindException.class})
    protected ResponseEntity<RequestErrorDTO> handleBindConflict(BindException ex) {
        FieldError fieldError = ex.getBindingResult().getFieldErrors().stream().findFirst().orElse(null);

        return getResponse(fieldError);
    }

    @ExceptionHandler({ConversionNotSupportedException.class})
    protected ResponseEntity<RequestErrorDTO> handleConversionNotSupportedConflict(BindException ex) {
        return getResponse(ErrorConstants.INVALID_PARAMETER);
    }
}

