package exersice.mvc.ss1_haiTT.controller;

import exersice.mvc.ss1_haiTT.service.IStudentService;
import exersice.mvc.ss1_haiTT.service.impl.StudentService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentController  {
    private static IStudentService iStudentService;

    static {
        iStudentService = new StudentService();
    }

    private static Scanner scanner = new Scanner(System.in);

    public static void menuStudent() throws IOException {
        while (true) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Chào mừng bạn đến với chương trình quản lý học sinh CodeGym");
            System.out.println("1. Thêm mới học sinh");
            System.out.println("2. Hiển thị danh sách học sinh");
            System.out.println("3. Xóa học sinh");
            System.out.println("4. Tìm kiếm học sinh");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc học sinh từ file");
            System.out.println("7. Ghi học sinh ra file");
            System.out.println("8. Thoát");
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
                    iStudentService.readStudent();
                    break;
                case 7:
                    iStudentService.writeStudent();
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("chọn lại nha mạyyyy");
                    return;
            }
        }
    }

    }

