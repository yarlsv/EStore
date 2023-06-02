package yar.mordvinov.estore.estore_impl.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import yar.mordvinov.estore.estore_api.dto.ExceptionResponse;
import yar.mordvinov.estore.estore_impl.exceptions.InvalidFeatureException;
import yar.mordvinov.estore.estore_impl.exceptions.ProductNotFoundException;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @org.springframework.web.bind.annotation.ExceptionHandler({InvalidFeatureException.class, HttpMessageNotReadableException.class})
    public ExceptionResponse handleFeatureException(RuntimeException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setErrorCode(HttpStatus.BAD_REQUEST.value());

        return response;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @org.springframework.web.bind.annotation.ExceptionHandler({ProductNotFoundException.class})
    public ExceptionResponse handleProductNotFoundException(RuntimeException exception) {
        ExceptionResponse response = new ExceptionResponse();
        response.setMessage(exception.getMessage());
        response.setErrorCode(HttpStatus.BAD_REQUEST.value());

        return response;
    }
}
