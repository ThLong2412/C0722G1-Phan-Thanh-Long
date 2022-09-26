package test.mvc.ss1_haiTT.controller;

import test.mvc.ss1_haiTT.service.IStudentService;
import test.mvc.ss1_haiTT.service.impl.StudentService;

import java.util.Scanner;

public class StudentController  {
    private static IStudentService iStudentService = new StudentService();
    private static Scanner scanner = new Scanner(System.in);

    public static void menuStudent() {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý học sinh CodeGym");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Tìm kiếm học sinh");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Thoát");
            System.out.println("Chọn đê bạn êiiiii");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    iStudentService.addStudent();
                    break;
                case 2:
                    iStudentService.displayAllStudent();
                    break;
                case 3:
                    iStudentService.removeStudent();
                    break;
                case 4:
                    iStudentService.findStudent();
                    break;
                case 5:
                    iStudentService.sortStudent();
                    break;
                case 6:
                    System.exit(0);
                    return;
                default:
                    System.out.println("chọn lại nha mạyyyy");
                    break;
            }
        }
    }

    }

