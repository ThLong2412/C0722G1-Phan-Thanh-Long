package customer.service.impl;

import customer.model.Customer;
import customer.repositoy.ICustomerRepository;
import customer.repositoy.impl.CustomerRepository;
import customer.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> listCustomer() {
        return customerRepository.listCustomer();
    }
}
