package com.uao.taskmanager.TaskManager.configuration;

import com.uao.taskmanager.TaskManager.domain.authentication.GenericResponseErrorDTO;
import com.uao.taskmanager.TaskManager.domain.controlleradvice.ControllerAdviceErrorDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
      = { InvalidParameterException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    protected GenericResponseErrorDTO handleConflict(
      RuntimeException ex, WebRequest request) {

         return GenericResponseErrorDTO.builder().errors(List.of(ex.getMessage())).path(request.getContextPath()).code(HttpStatus.BAD_REQUEST.value()).build();

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
            .stream().map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage()).collect(Collectors.toList());

        var genericResponse = GenericResponseErrorDTO.builder().errors(errors).code(HttpStatus.BAD_REQUEST.value()).path(request.getContextPath()).build();

        return new ResponseEntity<>(genericResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}