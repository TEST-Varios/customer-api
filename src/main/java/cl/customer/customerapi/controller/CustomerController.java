package cl.customer.customerapi.controller;

import cl.customer.customerapi.config.JwtUtil;
import cl.customer.customerapi.config.SwaggerConfig;
import cl.customer.customerapi.model.entity.Customers;
import cl.customer.customerapi.service.servicios.ICustomersService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Api(value = "Controller Manager New Clients")
@Import(SwaggerConfig.class)
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private static final String SECRET = "your-secret-key";
    private static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }
    @Autowired
    private ICustomersService iCustomersService;

    @ApiOperation(value = "Listado de clientes", response = CustomerController.class)
    @GetMapping("/getAllCustomers")
    public List<Customers> getAllCostumers() {

        try {
            if (iCustomersService.getAllCustomers().isEmpty()) {
                log.error("No se encuentran datos de clientes!!");
            }

            return iCustomersService.getAllCustomers();

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo encontrar Datos!", ex);
        }
    }

    @ApiOperation(value = "Entrega detalle del Cliente por ID", response = CustomerController.class)
    @GetMapping("/getCostumerId/{custId}")
    public Customers getCustomerId(@PathVariable Long id) {

        try {
            if (id == null){
                log.error("Dato ID vacio !!");
            }
            return iCustomersService.getByIdCustomer(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo encontrar Datos!", ex);
        }
    }


    @ApiOperation(value = "Guarda nuevos Clientes", response = CustomerController.class)
    @PostMapping("/saveCustomer")
    public Customers saveCustomer (@RequestBody Customers customers) {

        try {
            if (customers == null) {
                log.error("Error con los datos de entrada");
            }
            return iCustomersService.saveCustomer(customers);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo grabar Datos!", ex);
        }
    }


    @ApiOperation(value = "Borra Clientes de la lista", response = CustomerController.class)
    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@PathVariable Long id) {

        try {
            iCustomersService.deleteCustomer(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo borrar Datos!", ex);
        }
    }
}
