package furama_resort.service.impl;

import furama_resort.model.Customer;
import furama_resort.service.ICustomerService;
import furama_resort.utils.write_and_read.ReadFile;
import furama_resort.utils.write_and_read.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    List<Customer> customerList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        customerList= ReadFile.readFileCustomer("src/furama_resort/data/customer.csv");
        for (Customer customer : customerList) {
            System.out.println(customer.toString());
        }
        WriteFile.writeFileCustomer(customerList,"src/furama_resort/data/customer.csv");
    }

    @Override
    public void add() {
        customerList= ReadFile.readFileCustomer("src/furama_resort/data/customer.csv");

        Customer customer = this.info();
        customerList.add(customer);
        WriteFile.writeFileCustomer(customerList,"src/furama_resort/data/customer.csv");
        System.out.println("Thêm thành công");


    }

    @Override
    public void edit() {
        customerList= ReadFile.readFileCustomer("src/furama_resort/data/customer.csv");

        System.out.println("Nhập mã khách hàng cần sửa thông tin:");
        int id= Integer.parseInt(sc.nextLine());
        Customer customer;
        boolean isId=false;
        for (int i=0;i<customerList.size();i++){
            if (customerList.get(i).getId()==id){
                customerList.remove(i);
                System.out.println("Nhập các thông tin mới:");
                customer=this.info();
                customerList.add(i,customer);
                System.out.println("Sửa thành công");
                isId=true;
                break;
            }
        }
        if (!isId){
            System.out.println("Không tìm thấy mã khách hàng cần sửa");
        }
        WriteFile.writeFileCustomer(customerList,"src/furama_resort/data/customer.csv");

    }

    public Customer info() {
        System.out.println("Nhập mã khách hàng:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập họ tên khách hàng:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh khách hàng theo định dạng dd/MM/yyyy:");
        String birthday = sc.nextLine();
        System.out.println("Nhập giới tính khách hàng:");
        String gender = sc.nextLine();
        if (gender.equals("Nam") || gender.equals("nam")) {
            gender = "Nam";
        } else if (gender.equals("Nữ") || gender.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Không xác định";
        }
        System.out.println("Nhập CMND khách hàng:");
        String identityCard = sc.nextLine();
        System.out.println("Nhập số điện thoại khách hàng:");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập email khách hàng:");
        String email = sc.nextLine();
        int choise=0;
        String customerType="";
        while (choise==0){
            System.out.println("Chọn loại khách hàng:");
            System.out.println("1.Diamond");
            System.out.println("2.Platinium");
            System.out.println("3.Gold");
            System.out.println("4.Silver");
            System.out.println("5.Member");
            System.out.println("Mời chọn số");
            choise = Integer.parseInt(sc.nextLine());
            switch (choise){
                case 1:
                    customerType="Diamond";
                    break;
                case 2:
                    customerType="Platinium";
                    break;
                case 3:
                    customerType="Gold";
                    break;
                case 4:
                    customerType="Silver";
                    break;
                case 5:
                    customerType="Member";
                    break;
                default:
                    System.out.println("Mời chọn lại:");
            }
        }
        System.out.println("Nhập địa chỉ của khách hàng:");
        String address = sc.nextLine();
        Customer customer = new Customer(id, name, birthday, gender, identityCard, phoneNumber, email, customerType, address);
        return customer;
    }
}
