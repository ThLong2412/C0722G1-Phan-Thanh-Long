package case_study.service.impl;


import case_study.model.person.Employee;
import case_study.service.IEmployeeService;


import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeServiceImpl implements IEmployeeService {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Employee> employeeList = new ArrayList<>();
    final String[] levelArray = {"Trung cấp", "Cao đẳng", "Đại học", "Sau đại học"};
    final String[] locationArray = {"Lễ tân", "Phục vụ", "chuyên viên", "Giám sát", "Quản lý", "Giám đốc"};
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void readFileEmployee() {
        employeeList = new ArrayList<>();
        try {
            File file = new File("src\\case_study\\data\\employee.csv");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] info;
            Employee employee;
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                employee = new Employee(info[0], info[1], LocalDate.parse(info[2]), info[3], info[4], info[5], info[6], info[7], info[8], info[9]);
                employeeList.add(employee);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("File không có gì hãy tiếp tục chương trình");
        }
    }

    public static void writeFileEmployee() {
        try {
            File file = new File("src\\case_study\\data\\employee.csv");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee : employeeList) {
                bufferedWriter.write(employee.getInfo());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public void editEmployee() {
        readFileEmployee();
        System.out.println("nhập mã nhân viên muốn sửa");
        String codeEdit = scanner.nextLine();
        boolean flag = true;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCode().equals(codeEdit)) {
                flag = false;
                System.out.println("nhập mã nhân viên mới");
                String code = scanner.nextLine();
                employeeList.get(i).setCode(code);

                String name;
                while (true) {
                    try {
                        System.out.println("nhập tên nhân viên mới");
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
                employeeList.get(i).setName(name);

                LocalDate dayOfBirth;
                while (true) {
                    System.out.println("nhập ngày sinh nhân viên mới");
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
                employeeList.get(i).setDayOffBirth(dayOfBirth);

                String gender;
                while (true) {
                    System.out.println("nhập giới tính nhân viên mới");
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
                employeeList.get(i).setGender(gender);
                String idNumbers;
                while (true) {
                    System.out.println("nhập số CMND/CCCD của nhân viên mới");
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
                employeeList.get(i).setIdNumbers(idNumbers);

                String phoneNumbers;
                while (true) {
                    System.out.println("nhập số điện thoại nhân viên mới");
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
                employeeList.get(i).setPhoneNumbers(phoneNumbers);
                String email;
                while (true) {
                    System.out.println("nhập email nhân viên mới");
                    email = scanner.nextLine();
                    try {
                        if (email.matches("^[A-Za-z0-9]+[@][A-Za-z0-9]+[.][A-Za-z0-9]+$")) {
                            System.out.println("Định dạng email phù hợp");
                            break;
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Định dạng email sai hãy nhập lại");
                    }
                }
                employeeList.get(i).setEmail(email);
                String level;
                while (true) {
                    System.out.println("nhập trình độ nhân viên mới");
                    level = scanner.nextLine();
                    boolean flagEmail = true;
                    try {
                        for (int j = 0; j < levelArray.length; j++) {
                            if (levelArray[j].equals(level)) {
                                System.out.println("Trình độ đã có trong tiêu chuẩn");
                                flagEmail = false;
                                break;
                            }
                        }
                        if (flagEmail) {
                            break;
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Trình độ chưa phù hợp");
                    }
                }
                employeeList.get(i).setLevel(level);
                String location;
                while (true) {
                    System.out.println("nhập vị trí nhân viên mới");
                    location = scanner.nextLine();
                    boolean flagLocation = true;
                    try {
                        for (int j = 0; j < locationArray.length; j++) {
                            if (locationArray[j].equals(location)) {
                                System.out.println("Vị trí hợp lệ");
                                flagLocation = false;
                                break;
                            }
                        }
                        if (flagLocation) {
                            break;
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Vị trí chưa hợp lệ");
                    }
                }
                employeeList.get(i).setLocation(location);

                String wage;
                while (true) {
                    System.out.println("nhập lương nhân viên mới");
                    wage = scanner.nextLine();
                    try {
                        if (wage.matches("^[0-9]+[0]{3}")) {
                            System.out.println("Lương đã đúng định dạng");
                            break;
                        } else {
                            throw new Exception();
                        }
                    } catch (Exception e) {
                        System.out.println("Lương chưa đúng định dạng");
                    }
                }
                employeeList.get(i).setWage(wage);

                System.out.println("Đã sửa thành công.");
                break;
            }
            if (flag) {
                System.out.println("Không tìm thấy nhân viên có id: " + codeEdit);
            }
        }

    }

    @Override
    public void add() {
        readFileEmployee();
        Employee employee = this.infoEmployee();
        employeeList.add(employee);
        System.out.println("Thêm mới nhân viên thành công");
        writeFileEmployee();
    }

    public Employee infoEmployee() {
        System.out.println("nhập mã nhân viên");
        String code = scanner.nextLine();
        System.out.println("nhập tên nhân viên");
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
        System.out.println("nhập ngày sinh nhân viên");
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
        System.out.println("nhập giới tính nhân viên");
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
        System.out.println("nhập số CMND/CCCD của nhân viên");
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
        System.out.println("nhập số điện thoại nhân viên");
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
        System.out.println("nhập email nhân viên");
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
        System.out.println("nhập trình độ nhân viên");
        String level;
        while (true) {
            level = scanner.nextLine();
            boolean flagEmail = false;
            try {
                for (int j = 0; j < levelArray.length; j++) {
                    if (levelArray[j].equals(level)) {
                        System.out.println("Trình độ đã có trong tiêu chuẩn");
                        flagEmail = true;
                        break;
                    }
                }
                if (flagEmail) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Trình độ chưa phù hợp");
            }
        }
        System.out.println("nhập vị trí nhân viên");
        String location;
        while (true) {
            location = scanner.nextLine();
            boolean flagLocation = false;
            try {
                for (int j = 0; j < locationArray.length; j++) {
                    if (locationArray[j].equals(location)) {
                        System.out.println("Vị trí hợp lệ");
                        flagLocation = true;
                        break;
                    }
                }
                if (flagLocation) {
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Vị trí chưa hợp lệ");
            }
        }
        System.out.println("nhập lương nhân viên");
        String wage;
        while (true) {
            wage = scanner.nextLine();
            try {
                if (wage.matches("^[0-9]+[0]{3}$")) {
                    System.out.println("Lương đã đúng định dạng");
                    break;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("Lương chưa đúng định dạng");
            }
        }

        Employee employee = new Employee(code, name, dayOfBirth, gender, idNumbers, phoneNumbers, email, level, location, wage);
        return employee;
    }

    @Override
    public void display() {
        readFileEmployee();
        for (Employee employee : employeeList) {
            System.out.println("Thông tin nhân viên là: " + employee);
        }
    }
}
