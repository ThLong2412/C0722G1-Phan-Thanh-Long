package repositoy;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> listCustomer();
    boolean delete(int id) ;
    boolean update(Customer customer) ;
    Customer getCustomerById(int id) ;
    boolean addCustomer(Customer customer);
    List<Customer> search(String name);
}
