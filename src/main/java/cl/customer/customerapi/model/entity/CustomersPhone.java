package cl.customer.customerapi.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@Table(name = "customers_phone")
public class CustomersPhone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private int cityCode;

    private int countryCode;

    @ManyToOne
    private Customers customersPhones;

}
