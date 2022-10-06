package furama_resort.utils.write_and_read;

import furama_resort.model.Customer;
import furama_resort.model.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<Employee> readFileEmployee(String filePath) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Employee employee = new Employee();
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                employee.setId(Integer.parseInt(info[0]));
                employee.setName(info[1]);
                employee.setBirthday(info[2]);
                employee.setGender(info[3]);
                employee.setIdentityCard(info[4]);
                employee.setPhoneNumber(info[5]);
                employee.setEmail(info[6]);
                employee.setLevel(info[7]);
                employee.setPosition(info[8]);
                employee.setWage(Double.parseDouble(info[9]));
                employeeList.add(employee);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public static List<Customer> readFileCustomer(String filePath) {
        List<Customer> customerList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Customer customer = new Customer();
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                customer.setId(Integer.parseInt(info[0]));
                customer.setName(info[1]);
                customer.setBirthday(info[2]);
                customer.setGender(info[3]);
                customer.setIdentityCard(info[4]);
                customer.setPhoneNumber(info[5]);
                customer.setEmail(info[6]);
                customer.setCustomerType(info[7]);
                customer.setAddress(info[8]);
                customerList.add(customer);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
