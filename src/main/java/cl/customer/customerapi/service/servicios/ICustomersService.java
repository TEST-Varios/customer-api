package cl.customer.customerapi.service.servicios;

import cl.customer.customerapi.model.entity.Customers;

import java.util.List;
import java.util.Optional;

public interface ICustomersService {

    List<Customers> getAllCustomers();
    Customers getByIdCustomer(Long id);
    Customers saveCustomer(Customers customer);
    void deleteCustomer(Long id);
}
