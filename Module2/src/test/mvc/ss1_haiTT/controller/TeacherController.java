package test.mvc.ss1_haiTT.controller;

import test.mvc.ss1_haiTT.service.ITeacherService;
import test.mvc.ss1_haiTT.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private static ITeacherService iTeacherService = new TeacherService();
    private static Scanner scanner = new Scanner(System.in);

    public static void menuTeacher() {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý giảng viên CodeGym");
            System.out.println("1. Thêm mới giang vien");
            System.out.println("2. Hiển thị danh sách giang vien");
            System.out.println("3. Xóa giang vien");
            System.out.println("4. Tìm kiếm GV");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Thoát");
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
                    iTeacherService.findTeacher();
                    break;
                case 5:
                    iTeacherService.sortTeacher();
                    break;
                case 6:
                    System.exit(0);
                    return;
                default:
                    System.out.println("vui long chon lai nha cau iuu");
                    break;
            }
            }
    }
}