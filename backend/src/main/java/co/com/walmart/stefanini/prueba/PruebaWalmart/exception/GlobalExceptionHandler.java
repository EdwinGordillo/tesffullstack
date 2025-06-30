package co.com.walmart.stefanini.prueba.PruebaWalmart.exception;

import co.com.walmart.stefanini.prueba.PruebaWalmart.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDTO<?> handleResponseStatusException(ResponseStatusException ex) {
        return new ResponseDTO<>(false, ex.getReason(), Collections.emptyList());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDTO<?> handleGenericException(Exception ex) {
        return new ResponseDTO<>(false, "Error inesperado: " + ex.getMessage(), Collections.emptyList());
    }
}
