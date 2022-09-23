package test.mvc.ss1.service.impl;

import test.mvc.ss1.model.Student;
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

    public void findTeacher() {
        System.out.println("1. tìm kiếm theo tên giảng viên");
        System.out.println("2. tìm kiếm theo mã giảng viên");
        System.out.println("mời bạn lựa chọn");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.println("nhập tên giảng viên muốn tìm");
                String nameFind = scanner.nextLine();

                boolean flag = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getName().contains(nameFind)) {
                        System.out.println(teacherList.get(i));
                        flag = true;
                        break;
                    }
                    if (!flag) {
                        System.out.println("không tìm thấy giảng viên");
                    }
                }
                break;
            case 2:
                System.out.println("nhập mã giảng viên muốn tìm");
                String codeFind = scanner.nextLine();

                boolean flag2 = false;
                for (int i = 0; i < teacherList.size(); i++) {
                    if (teacherList.get(i).getCode().equals(codeFind)) {
                        System.out.println(teacherList.get(i));
                        flag2 = true;
                        break;
                    }
                    if (!flag2) {
                        System.out.println("không tìm thấy giảng viên");
                    }
                }
                break;
        }
    }
    public void sortTeacher(){
        if (teacherList.size() <=0) {
            System.out.println("Không có danh sách để sắp xếp");
            return;
        }
        boolean isSwap = true;
        for (int i = 0; i < teacherList.size() -1; i++) {
            isSwap = false;
            for (int j = i + 1; j < teacherList.size() - i -1; j++) {
                if (teacherList.get(j).compareTo(teacherList.get(j+1) ) > 0) {
                    isSwap = true;
                    Teacher temp = teacherList.get(j+1);
                    teacherList.set(j+1, teacherList.get(j));
                    teacherList.set(j, temp);
                }

            }

        }
        System.out.println("Đã sắp xếp thành công \n Danh sách sau khi sắp xếp là: ");
    }
}
