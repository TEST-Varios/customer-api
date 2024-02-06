package cl.customer.customerapi.model.entity;

import lombok.*;
import java.util.Date;

@Data
@AllArgsConstructor
public class ResponseCustomer {

    private String id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;
    private Boolean inActive;

}