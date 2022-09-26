package test.mvc.ss1_haiTT.service.impl;


import test.mvc.ss1_haiTT.model.Student;
import test.mvc.ss1_haiTT.service.IStudentService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentService implements IStudentService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> studentList = new ArrayList<>();


    public Student displayStudent() {
        System.out.print("Mời bạn nhập mã học sinh: ");
        String code = scanner.nextLine();
        String name;
        while (true) {
            System.out.print("Mời bạn nhập tên học sinh: ");
            name = scanner.nextLine();
            try {
                checkName(name);
                System.out.println("Tên đúng định đạng");
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Mời bạn nhập ngày sinh học sinh: ");
        String pattern;
        while (true) {
            pattern = scanner.nextLine();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                dateFormat.parse(pattern);
                System.out.println("Định dạng ngày tháng năm đúng");
                break;
            } catch (ParseException e) {
                System.out.println("Định dạng ngày tháng năm bị lỗi \n Vui lòng nhập lại");
            }
        }
        
        String gender;
        while (true) {
            System.out.println("Mời bạn nhập giới tính học sinh: ");
            gender = scanner.nextLine();
            try {
                checkGender(gender);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Mời bạn nhập tên lớp: ");
        String classes = scanner.nextLine();
        double score;
        while (true) {
            System.out.print("Mời bạn nhập điểm của học sinh: ");
            score = Double.parseDouble(scanner.nextLine());
            try {
                checkScore(score);
                break;
            } catch (Check e) {
                System.out.println(e.getMessage());
            }
        }

        Student student = new Student(code, name, pattern, gender, classes, score);
        return student;
    }

    public void addStudent() {
        Student student = this.displayStudent();
        studentList.add(student);
        System.out.println("Đã thêm mới học sinh thành công.");
    }

    @Override
    public void displayAllStudent() {
        for (Student ch : studentList) {
            System.out.println(ch);
        }
    }

    @Override
    public void removeStudent() {
        System.out.print("Mời bạn nhập mã học sinh cần xóa: ");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa học sinh này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    studentList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        }
        if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
    }

    public void findStudent() {
        System.out.println("1. Tìm kiếm theo tên");
        System.out.println("2. Tìm kiếm theo mã");
        System.out.println("mời bạn lựa chọn");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("nhập tên học sinh muốn tìm");
                String nameFind = scanner.nextLine();
                boolean flag = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getName().contains(nameFind)) {
                        System.out.println(studentList.get(i));
                        flag = true;
                        break;
                    }
                    if (!flag) {
                        System.out.println("không tìm thấy học sinh");
                    }
                }
                break;
            case 2:
                System.out.println("nhập mã muốn tìm");
                String codeFind = scanner.nextLine();
                boolean flag2 = false;
                for (int i = 0; i < studentList.size(); i++) {
                    if (studentList.get(i).getCode().equals(codeFind)) {
                        System.out.println(studentList.get(i));
                        flag2 = true;
                        break;
                    }
                    if (!flag2) {
                        System.out.println("không tìm thấy học sinh");
                    }
                }
                break;
        }
    }

    public void sortStudent() {
        if (studentList.size() <= 0) {
            System.out.println("Không có danh sách để sắp xếp");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < studentList.size() - 1 && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < studentList.size() - 1 - i; j++) {
                if (studentList.get(j).compareTo(studentList.get(j + 1)) > 0) {
                    isSwap = true;
                    Student temp = studentList.get(j + 1);
                    studentList.set(j + 1, studentList.get(j));
                    studentList.set(j, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp thành công");
    }

    public void checkName(String name) throws Check {
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                throw new Check("Lỗi: tên không được tồn tại ký tự số");
            }
        }
    }

    public void checkGender(String gender) throws Check {
        if (!gender.equals("Nam") && !gender.equals("Nữ")) {
            throw new Check("Giới tính chỉ có Nam hoặc Nữ ");
        } else {
            System.out.println("Giới tính đã đúng");
        }
    }

    public void checkScore(double score) throws Check {
        if (score > 10 || score < 0) {
            throw new Check("Điểm số cần bé hơn 10 và lớn hơn 0: ");
        } else {
            System.out.println("Điểm đã đúng định dạng");
        }
    }
}
