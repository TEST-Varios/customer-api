package cl.customer.customerapi.service.implementacion;

import cl.customer.customerapi.model.dao.ICustumersDao;
import cl.customer.customerapi.model.entity.Customers;
import cl.customer.customerapi.service.servicios.ICustomersService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomersImpl implements ICustomersService {

    private final ICustumersDao iCustumersDao;

    public CustomersImpl(ICustumersDao iCustumersDao) {
        this.iCustumersDao = iCustumersDao;
    }

    @Override
    public List<Customers> getAllCustomers() {
        return (List<Customers>)  iCustumersDao.findAll();
    }

    @Override
    public Customers getByIdCustomer(Long id) {
        return iCustumersDao.findById(id).orElse(null);
    }

    @Override
    public Customers saveCustomer(Customers customer) {
        return iCustumersDao.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        iCustumersDao.deleteById(id);
    }
}
