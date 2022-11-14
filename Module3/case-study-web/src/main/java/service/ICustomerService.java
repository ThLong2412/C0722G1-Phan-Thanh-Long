package service;

import model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> listCustomer();
    boolean delete(int id) ;
    boolean update(Customer customer) ;
    Customer getCustomerById(int id);
    Map<String,String> addCustomer(Customer customer);
    List<Customer> search(String name);
}
