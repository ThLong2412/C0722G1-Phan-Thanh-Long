package validation;

import model.Customer;
import service.ICustomerService;
import service.impl.CustomerService;

import java.util.List;

public class Validation {
    private static ICustomerService customerService = new CustomerService();
    public static boolean checkCode(int code){
        boolean check = false;
        List<Customer> customerList = customerService.listCustomer();
        for (int i = 0; i < customerList.size(); i++) {
            if (code != customerList.get(i).getId()) {
                check = true;
            } else {
                check = false;
                break;
            }
        }
        return check;
    }
}
