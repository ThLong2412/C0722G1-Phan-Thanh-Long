package test.mvc.ss1.view;

import test.mvc.ss1.controller.StudentController;
import test.mvc.ss1.controller.TeacherController;

import java.util.Scanner;

public class View {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========== *Chương trình quản lý học sinh và giảng viên* ==========");
        System.out.println("1. Quản lý học sinh");
        System.out.println("2. Quản lý giảng viên");
        System.out.println("Chọn đê bạn êiiiii");

        int choice = Integer.parseInt(scanner.nextLine());
        while (true) {
            switch (choice) {
                case 1:
                    StudentController.menuStudent();
                    break;
                case 2:
                    TeacherController.menuTeacher();
                    break;
                default:
                    System.out.println("vui lòng chọn lại");
                    return;
            }
        }

    }
}
