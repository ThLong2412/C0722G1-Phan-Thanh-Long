package exam.controller;

import exam.service.ITaiKhoanThanhToanService;
import exam.service.impl.TaiKhoanThanhToanService;

import java.util.Scanner;

public class TaiKhoanThanhToanController {
    private static Scanner scanner = new Scanner(System.in);
    private static ITaiKhoanThanhToanService iTaiKhoanThanhToanService = new TaiKhoanThanhToanService();
    public static void mainMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN THANH TOÁN--");
        System.out.println("Chọn chức năng theo số(để tiếp tục)");
        System.out.println("1.Thêm mới \n 2. Xóa \n 3.Xem danh sách tài khoản ngân hàng. \n 4. Tìm kiếm \n 5. Thoát");
        String choice;
        while (true) {
            System.out.println("Mời bạn lựa chọn");

            try {
                choice = scanner.nextLine();
                if (choice.matches("^[1-5]$")) {
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("định dạng sai vui lòng nhập lại");
            }
        }
        while (true) {
            switch (choice) {
                case "1":
                    iTaiKhoanThanhToanService.add();
                    break;
                case "2":
                    iTaiKhoanThanhToanService.remove();
                    break;
                case "3":
                    iTaiKhoanThanhToanService.display();
                    break;
                case "4":
                    iTaiKhoanThanhToanService.search();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Vui lòng lựa chọn các mục đã định");
            }
        }
    }
}
