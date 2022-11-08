package customer.repositoy;

import customer.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> listCustomer();
}
