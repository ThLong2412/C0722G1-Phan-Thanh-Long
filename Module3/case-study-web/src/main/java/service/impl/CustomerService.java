package service.impl;

import model.Customer;
import repositoy.ICustomerRepository;
import repositoy.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> listCustomer() {
        return customerRepository.listCustomer();
    }

    @Override
    public boolean delete(int id)  {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer)  {
        return customerRepository.update(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.addCustomer(customer);
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.search(name);
    }
}
