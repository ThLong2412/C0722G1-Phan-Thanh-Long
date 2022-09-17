package test.mvc.controller;

import test.mvc.service.ITeacherService;
import test.mvc.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static ITeacherService iTeacherService = new TeacherService();
    private static Scanner scanner = new Scanner(System.in);

    public static void menuTeacher() {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý CodeGym");
            System.out.println("1. Thêm mới giang vien");
            System.out.println("2. Hiển thị danh sách giang vien");
            System.out.println("3. Xóa giang vien");
            System.out.println("4. Thoát");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iTeacherService.addTeacher();
                    break;
                case 2:
                    iTeacherService.displayAllTeacher();
                    break;
                case 3:
                    iTeacherService.removeTeacher();
                    break;
                case 4:
                    System.exit(0);
                    return;
            }
            }
    }
}
