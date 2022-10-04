package case_study.controller;

import case_study.service.IBookingService;
import case_study.service.ICustomerService;
import case_study.service.IEmployeeService;
import case_study.service.IFacilityService;
import case_study.service.impl.BookingServiceImpl;
import case_study.service.impl.CustomerServiceImpl;
import case_study.service.impl.EmployeeServiceImpl;
import case_study.service.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService iEmployeeService = new EmployeeServiceImpl();
    private static ICustomerService iCustomerService = new CustomerServiceImpl();
    private static IFacilityService iFacilityService = new FacilityServiceImpl();
    private static IBookingService iBookingService = new BookingServiceImpl();

    public static void displayMainMenu() {
        System.out.println("Chào mừng bạn đến với chương trình quản lý khu nghỉ dưỡng FURAMA");
        System.out.println("1. Quản lý nhân viên");
        System.out.println("2. Quản lý khách hàng");
        System.out.println("3. Quản lý cơ sở vật chất ");
        System.out.println("4. Quản lý đặt vé");
        System.out.println("5. Quản lý khuyến mãi");
        System.out.println("6. Thoát chương trình");

        String choice;
        while (true) {
            System.out.println("Mời bạn lựa chọn");
            choice  = scanner.nextLine();
            try {
                if (choice.matches("^[1-6]$")) {
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
                while (true) {
                    System.out.println("chương trình quản lý nhân viên");
                    System.out.println("1\tHiển thị danh sách nhân viên\n" +
                            "2\tThêm mới nhân viên\n" +
                            "3\tChỉnh sửa nhân viên\n" +
                            "4\tVề lại menu chính\n");
                    System.out.println("Mời bạn lựa chọn");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            iEmployeeService.display();
                            break;
                        case 2:
                            iEmployeeService.add();
                            break;
                        case 3:
                            iEmployeeService.editEmployee();
                            break;
                        case 4:
                            FuramaController.displayMainMenu();
                            break;
                        default:
                            System.out.println("vui lòng chọn đúng với các thao tác đã quy sẵn");
                            return;
                    }
                }
            case "2":
                while (true) {
                    System.out.println("chương trình quản lý khách hàng");
                    System.out.println("1.\tHiển thị danh sách khách hàng\n" +
                            "2.\tThêm mới khách hàng\n" +
                            "3.\tChỉnh sửa thông tin khách hàng\n" +
                            "4.\tVề menu chính\n");
                    System.out.println("Mời bạn lựa chọn");
                    int choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
                        case 1:
                            iCustomerService.display();
                            break;
                        case 2:
                            iCustomerService.add();
                            break;
                        case 3:
                            iCustomerService.editCustomer();
                            break;
                        case 4:
                            FuramaController.displayMainMenu();
                            break;
                        default:
                            System.out.println("vui lòng chọn đúng với các thao tác đã quy sẵn");
                            return;
                    }
                }

            case "3":
                System.out.println("Chương trình quản lý cơ sở");
                System.out.println("1\tHiển thị danh sách cơ sở \n" +
                        "2\tThêm mới cơ sở \n" +
                        "3\tHiển thị danh sách cơ sở bảo trì\n" +
                        "4\tVề lại menu chính\n");
                System.out.println("Mời bạn lựa chọn");
                int choice3 = Integer.parseInt(scanner.nextLine());

                switch (choice3) {
                    case 1:
                        iFacilityService.display();
                        break;
                    case 2:
                        System.out.println("chương trình thêm mới cơ sở");
                        iFacilityService.add();
                        break;
                    case 3:
                        iFacilityService.maintenanceDisplay();
                        break;
                    default:
                        System.out.println("vui lòng chọn đúng với các thao tác đã quy sẵn");
                        return;
                }
                break;
            case "4":
                System.out.println("Chương trình quản lý đặt vé");
                System.out.println("1.\tThêm mới đặt vé\n" +
                        "2.\tHiển thị danh sách đặt vé\n" +
                        "3.\tThêm mới hợp đồng\n" +
                        "4.\tHiển thị danh sách hợp đồng\n" +
                        "5.\tChỉnh sửa hợp đồng\n" +
                        "6.\tVề lại menu chính\n");
                System.out.println("Mời bạn lựa chọn");
                int choice4 = Integer.parseInt(scanner.nextLine());
                switch (choice4) {
                    case 1:
                       iBookingService.add();
                       break;
                    case 2:
                        iBookingService.display();
                        break;
                    case 3:
                        iBookingService.addContract();
                        break;
                    case 4:
                        iBookingService.displayContract();
                        break;
                    case 5:
                        iBookingService.editContract();
                        break;
                    case 6:
                        FuramaController.displayMainMenu();
                        break;
                    default:
                        System.out.println("vui lòng chọn đúng với các thao tác đã quy sẵn");
                        return;
                }
                break;
            case "5":
                System.out.println("1.\tHiển thị danh sách khách hàng sử dụng dịch vụ\n" +
                        "2.\tHiển thị danh sách khách hàng được tặng voucher\n" +
                        "3.\tVề lại menu chính\n");
                break;
            case "6":
                System.out.println(" Thoát chương trình thành công");
                System.exit(0);
        }
    }
}
