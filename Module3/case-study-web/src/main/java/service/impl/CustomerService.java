package service.impl;

import model.Customer;
import repositoy.ICustomerRepository;
import repositoy.impl.CustomerRepository;
import service.ICustomerService;
import validation.Validation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<Customer> listCustomer() {
        return customerRepository.listCustomer();
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public Map<String, String> addCustomer(Customer customer) {
        Map<String, String> errorMap = new HashMap<>();
        if (!Validation.checkCode(customer.getId())) {
            errorMap.put("errorId", "Id không được trùng");
        }
        if (errorMap.size()==0) {
            customerRepository.addCustomer(customer);
        }
        return errorMap;
    }

    @Override
    public List<Customer> search(String name) {
        return customerRepository.search(name);
    }

}
