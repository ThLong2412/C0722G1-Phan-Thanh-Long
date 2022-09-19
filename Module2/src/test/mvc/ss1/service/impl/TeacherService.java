package test.mvc.ss1.service.impl;

import test.mvc.ss1.model.Teacher;
import test.mvc.ss1.service.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Teacher> teacherList = new ArrayList<>();

    public void addTeacher() {
        Teacher teacher = this.displayTeacher();
        teacherList.add(teacher);
        System.out.println("Da them moi giang vien thanh cong");
    }

    public Teacher displayTeacher() {
        System.out.println("nhap ma giang vien");
        String code = scanner.nextLine();
        System.out.println("nhap ten giang vien");
        String name = scanner.nextLine();
        System.out.println("nhap ngay sinh giang vien");
        String pattern = scanner.nextLine();
        System.out.println("nhap gioi tinh giang vien");
        String gender = scanner.nextLine();
        System.out.println("nhap chuyen mon giang vien");
        String specializes = scanner.nextLine();
        Teacher teacher = new Teacher(code, name, pattern, gender, specializes);
        return teacher;
    }

    public void displayAllTeacher() {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    public void removeTeacher() {
        System.out.println("nhap ma GV can xoa");
        String code = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getCode().equals(code)) {
                System.out.println("Bạn có chắc muốn xóa GV này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    teacherList.remove(i);
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
}
