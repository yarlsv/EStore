package yar.mordvinov.estore.estore_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionResponse {

    private String message;
    private int errorCode;
}
