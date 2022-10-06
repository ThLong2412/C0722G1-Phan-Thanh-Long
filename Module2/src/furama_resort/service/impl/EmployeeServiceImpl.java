package furama_resort.service.impl;

import furama_resort.model.Employee;
import furama_resort.service.IEmployeeService;
import furama_resort.utils.write_and_read.ReadFile;
import furama_resort.utils.write_and_read.WriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    List<Employee> employeeList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void display() {
        employeeList = ReadFile.readFileEmployee("src/furama_resort/data/employee.csv");
        for (Employee employee : employeeList) {
            System.out.println(employee.toString());
        }
        WriteFile.writeFileEmployee(employeeList, "src/furama_resort/data/employee.csv");
    }

    @Override
    public void add() {
        employeeList = ReadFile.readFileEmployee("src/furama_resort/data/employee.csv");
        Employee employee = this.info();
        employeeList.add(employee);
        WriteFile.writeFileEmployee(employeeList, "src/furama_resort/data/employee.csv");
        System.out.println("Thêm thành công");

    }

    @Override
    public void edit() {
        employeeList = ReadFile.readFileEmployee("src/furama_resort/data/employee.csv");
        System.out.println("Nhập mã nhân viên cần sửa thông tin:");
        int id = Integer.parseInt(sc.nextLine());
        Employee employee;
        boolean isId = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                employeeList.remove(i);
                System.out.println("Nhập các thông tin mới:");
                employee = this.info();
                employeeList.add(i, employee);
                System.out.println("Sửa thành công");
                isId = true;
                break;
            }
        }
        if (!isId) {
            System.out.println("Không tìm thấy mã nhân viên cần sửa");
        }
        WriteFile.writeFileEmployee(employeeList, "src/furama_resort/data/employee.csv");

    }

    public Employee info() {
        System.out.println("Nhập mã nhân viên:");
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập họ tên nhân viên:");
        String name = sc.nextLine();
        System.out.println("Nhập ngày sinh nhân viên theo định dạng dd/MM/yyyy:");
        String birthday = sc.nextLine();
        System.out.println("Nhập giới tính nhân viên:");
        String gender = sc.nextLine();
        if (gender.equals("Nam") || gender.equals("nam")) {
            gender = "Nam";
        } else if (gender.equals("Nữ") || gender.equals("nữ")) {
            gender = "Nữ";
        } else {
            gender = "Không xác định";
        }
        System.out.println("Nhập CMND nhân viên:");
        String identityCard = sc.nextLine();
        System.out.println("Nhập số điện thoại nhân viên:");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập email nhân viên:");
        String email = sc.nextLine();

        String level="";
        int choise=0;
        while (choise==0) {
            System.out.println("Chọn trình độ nhân viên:");
            System.out.println("1.Trung cấp");
            System.out.println("2.Cao đẳng");
            System.out.println("3.Đại học");
            System.out.println("4.Sau đại học");
            System.out.println("Mời chọn số");
            choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    level = "Trung cấp";
                    break;
                case 2:
                    level = "Cao đẳng";
                    break;
                case 3:
                    level = "Đại học";
                    break;
                case 4:
                    level = "Sau đại học";
                    break;
                default:
                    System.out.println("Mời chọn lại:");
            }
        }
        String position="";
        int choise1=0;
        while (choise1==0){
            System.out.println("Chọn vị trí của nhân viên:");
            System.out.println("1.Lễ tân");
            System.out.println("2.Phục vụ");
            System.out.println("3.Chuyên viên");
            System.out.println("4.Giám sát");
            System.out.println("5.Quản lý");
            System.out.println("6.Giám đốc");
            System.out.println("Mời chọn số:");
            choise1 = Integer.parseInt(sc.nextLine());
            switch (choise1) {
                case 1:
                    position = "Lễ tân";
                    break;
                case 2:
                    position = "Phục vụ";
                    break;
                case 3:
                    position = "Chuyên viên";
                    break;
                case 4:
                    position = "Giám sát";
                    break;
                case 5:
                    position="Quản lý";
                    break;
                case 6:
                    position="Giám đốc";
                    break;
                default:
                    System.out.println("Mời chọn lại:");
            }
        }
        System.out.println("Nhập lương nhân viên:");
        double wage = Double.parseDouble(sc.nextLine());
        Employee employee = new Employee(id, name, birthday, gender, identityCard, phoneNumber, email, level, position, wage);
        return employee;
    }
}
