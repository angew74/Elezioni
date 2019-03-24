package com.deltasi.elezioni;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
    private static final Logger logger = LogManager.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler({Exception.class,TemplateInputException.class})
    public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(ApplicationConstants.SERVER_ERROR, details);
        logger.error(error.getDetails());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({RecordNotFoundException.class})
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(RecordNotFoundException ex,
                                                                           WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(ApplicationConstants.RECORD_NOT_FOUND, details);
        logger.error(error.getDetails());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
