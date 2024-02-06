package cl.customer.customerapi.model.dao;

import cl.customer.customerapi.model.entity.Customers;
import org.springframework.data.repository.CrudRepository;

public interface ICustumersDao extends CrudRepository<Customers, Long> {
}
