package cl.customer.customerapi.exeptions.handlers;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
public class ErrorInfo {

    @JsonProperty("message")
    private String message;

    @JsonProperty("status_code")
    private int statusCode;

    @JsonProperty("uri")
    private String uriRequested;

    public ErrorInfo(String message, int statusCode, String uriRequested) {
        super();

        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }
}