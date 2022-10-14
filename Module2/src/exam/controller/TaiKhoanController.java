package exam.controller;

import java.util.Scanner;

public class TaiKhoanController {
    private static Scanner scanner = new Scanner(System.in);

    public static void mainMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG--");
        System.out.println("Chọn chức năng theo số(để tiếp tục)");
        System.out.println("1.TÀI KHOẢN THANH TOÁN \n 2. TÀI KHOẢN TIẾT KIỆM");
        String choice;
        while (true) {
            System.out.println("Mời bạn lựa chọn");

            try {
                choice = scanner.nextLine();
                if (choice.matches("^[1-2]$")) {
                    break;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("định dạng sai vui lòng nhập lại");
            }
        }
        switch (choice) {
            case "1":
                TaiKhoanThanhToanController.mainMenu();
                break;
            case "2":
                TaiKhoanTietKiemController.mainMenu();
                break;
            default:
                System.out.println("Vui lòng lựa chọn các mục đã định");
        }
    }
}
