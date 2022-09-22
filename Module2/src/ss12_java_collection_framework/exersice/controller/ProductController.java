package ss12_java_collection_framework.exersice.controller;

import ss12_java_collection_framework.exersice.service.IProductService;
import ss12_java_collection_framework.exersice.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {

    private static IProductService iProductService = new ProductService();
    private static Scanner sc = new Scanner(System.in);

    public static void menuProduct() {
        while (true) {
            System.out.println("-----Chào mừng bạn đến với chương trình quản lý sản phẩm-----");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm theo id");
            System.out.println("3. Xóa sản phẩm theo id");
            System.out.println("4. Hiển thị danh sách sản phẩm");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá");
            System.out.println("7. Thoát chương trình");

            System.out.println("mời bạn lựa chọn");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    iProductService.addProduct();
                    break;
                case 2:
                    iProductService.editProduct();
                    break;
                case 3:
                    iProductService.removeProduct();
                    break;
                case 4:
                    iProductService.displayProduct();
                    break;
                case 5:
                    iProductService.findProduct();
                    break;
                case 6:
                    iProductService.sortProduct();
                    break;
                case 7:
                    System.exit(0);
                    return;
                default:
                    System.out.println("vui lòng lựa chọn lại");
            }
        }
    }
}
