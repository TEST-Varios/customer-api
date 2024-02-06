package cl.customer.customerapi.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "customers_data")
public class Customers implements Serializable {

    public Customers() {}

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "customersPhones", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CustomersPhone> phones;

    private String token;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date createAt;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date modified;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date lastLogin;

    @PrePersist
    public void preSaveCreate() {
        createAt = new Date();
        modified = new Date();
        lastLogin = new Date();
    }

    @Builder
    public Customers(String name, String email, List<CustomersPhone> phones, String token, Date createAt, Date modified, Date lastLogin) {
        this.name = name ;
        this.email = email ;
        this.phones = phones ;
        this.token = token ;
        this.createAt = createAt ;
        this.modified = modified ;
        this.lastLogin = lastLogin ;
    }

}