package case_study.service.impl;

import case_study.model.person.Customer;
import case_study.model.person.Employee;
import case_study.service.ICustomerService;


import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Customer> customerList = new ArrayList<>();
    final String[] typeCustomerArray = {"Diamond", "Platinium", "Gold", "Silver", "Member"};
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static List<Customer> readFileCustomer() {
        customerList = new ArrayList<>();
        try {
            File file = new File("src\\case_study\\data\\customer.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Customer customer;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                customer = new Customer(info[0], info[1], LocalDate.parse(info[2]), info[3], info[4], info[5], info[6], info[7], info[8]);
                customerList.add(customer);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File không có gì hãy tiếp tục chương trình");
        }
        return customerList;
    }

    public static void writeFileCustomer() {
        try {
            File file = new File("src\\case_study\\data\\customer.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer : customerList) {
                bufferedWriter.write(customer.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public void editCustomer() {
        readFileCustomer();
        System.out.println("nhập mã khách hàng muốn sửa");
        String codeEdit = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCode().equals(codeEdit)) {
                flag = true;
                customerList.set(i, infoCustomer());
                System.out.println("Ddax suwar thanhf coong");
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy nhân viên có id: " + codeEdit);
        }
    }

    @Override
    public void add() {
        readFileCustomer();
        Customer customer = this.infoCustomer();
        customerList.add(customer);
        System.out.println("thêm mới khách hàng thành công");
        writeFileCustomer();
    }

    @Override
    public void display() {
        customerList = readFileCustomer();
        for (Customer c : customerList) {
            System.out.println("Thông tin khách hàng là: " + c);
        }
    }

    public Customer infoCustomer() {
        System.out.println("nhập mã khách hàng");
        String code;
        while (true) {
            code = scanner.nextLine();
            try {
                if (code.matches("^[K][H][0-9]+$")) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Mã sai định dạng. Hãy nhập lại");
            }
        }
        System.out.println("nhập tên khách hàng");
        String name;
        while (true) {
            try {
                name = scanner.nextLine();

                if (name.matches("^([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*[\\s])*([A-Z][a-záàảạãăắằặẵâấầẫậẩéèẻẽẹêếềểễệóòỏõọôốồổỗộơớờởỡợíìỉĩịùúủũụưứửữựỵỷỹýỳ]*)$")) {
                    System.out.println("Tên đúng định đạng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Tên sai định dạng. Hãy nhập lại");
            }
        }
        System.out.println("nhập ngày sinh khách hàng");
        LocalDate dayOfBirth;
        while (true) {
            dayOfBirth = LocalDate.parse(scanner.nextLine(), formatter);
            try {
                LocalDate date = LocalDate.now();
                long day = dayOfBirth.until(date, ChronoUnit.DAYS);
                double old = day / 365.5;
                if (old > 18 && old < 100) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Ngày sinh sai định dạng. Hãy nhập lại");
            }
        }
        System.out.println("nhập giới tính khách hàng");
        String gender;
        while (true) {
            gender = scanner.nextLine();
            try {
                if (gender.equals("Nam") || gender.equals("Nữ")) {
                    System.out.println("Giới tính đã đúng ");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Giới tính không phù hợp. Hãy nhập lại");
            }
        }
        System.out.println("nhập số CMND/CCCD của khách hàng");
        String idNumbers;
        while (true) {
            idNumbers = scanner.nextLine();
            try {
                if (idNumbers.matches("^[0-9]{12}$")) {
                    System.out.println("Định dạng số CMND/CCCD đã đúng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Định dạng số CMND/CCCD đã sai. Hãy nhập lại");
            }
        }
        System.out.println("nhập số điện thoại khách hàng");
        String phoneNumbers;
        while (true) {
            phoneNumbers = scanner.nextLine();
            try {
                if (phoneNumbers.matches("^[0][0-9]{9}$")) {
                    System.out.println("Định dạng số điện thoại đã đúng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Định dạng số điện thoại sai. Hãy nhập lại");
            }
        }
        System.out.println("nhập email khách hàng");
        String email;
        while (true) {
            email = scanner.nextLine();
            try {
                if (email.matches("^[A-Za-z0-9]*[@][A-Za-z0-9]+[.][A-Za-z0-9]+$")) {
                    System.out.println("Định dạng email phù hợp");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Định dạng email sai hãy nhập lại");
            }
        }

        System.out.println("Nhập loại khách hàng");
        String typeCustomer;
        while (true) {
            typeCustomer = scanner.nextLine();
            boolean flagTypeCustomer = false;
            try {
                for (int i = 0; i < typeCustomerArray.length; i++) {
                    if (typeCustomerArray[i].equals(typeCustomer)) {
                        flagTypeCustomer = true;
                        System.out.println("Loại khách hàng hợp lệ");
                        break;
                    }
                }
                if (flagTypeCustomer) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Loại khách hàng bị lỗi");
            }
        }
        System.out.println("nhập địa chỉ khách hàng");
        String address = scanner.nextLine();

        Customer customer = new Customer(code, name, dayOfBirth, gender, idNumbers, phoneNumbers, email, typeCustomer, address);
        return customer;
    }
}
