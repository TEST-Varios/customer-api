package cl.customer.customerapi.exeptions.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandlerJson {

    private static MethodArgumentNotValidException errorJson;
    private static final Logger log = LoggerFactory.getLogger(ResponseHandlerJson.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public static ResponseEntity<Object> generateResponse(HttpStatus status, boolean error, String message, Object responseObj) {
        Map<String, Object> map = new HashMap<>();
        Date fechaSys = new Date();

        map.put("Status Code", status.value());
        map.put("Fecha", new SimpleDateFormat("dd-MM-yyyy HH:mm").format(fechaSys));
        map.put("isSuccess", error);
        map.put("Message", message);
        map.put("Data", responseObj);

        log.info("Datos respuesta :: ResponseHandlerJson: {}", responseObj);

        return new ResponseEntity<>(map, status);

    }
}
