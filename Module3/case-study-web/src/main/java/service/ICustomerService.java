package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> listCustomer();
    boolean delete(int id) ;
    boolean update(Customer customer) ;
    Customer getCustomerById(int id);
    void addCustomer(Customer customer);
    List<Customer> search(String name);
}
