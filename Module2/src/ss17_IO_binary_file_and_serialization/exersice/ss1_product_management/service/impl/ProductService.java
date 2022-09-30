package ss17_IO_binary_file_and_serialization.exersice.ss1_product_management.service.impl;

import ss17_IO_binary_file_and_serialization.exersice.ss1_product_management.model.Product;
import ss17_IO_binary_file_and_serialization.exersice.ss1_product_management.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();

    @Override
    public void addProduct() {
        try {
            readFile();
            Product product = this.infoProduct();
            productList.add(product);
            FileOutputStream fileOutputStream = new FileOutputStream("src\\ss17_IO_binary_file_and_serialization\\exersice\\ss1_product_management\\data\\fileProduct.csv");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(productList);
            objectOutputStream.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thêm mới vào file thành công");
    }

    public Product infoProduct() {
        System.out.println("Nhập mã sản phẩm muốn thêm");
        int code = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sản phẩm muốn thêm");
        String name = scanner.nextLine();
        System.out.println("Nhập hãng sản phẩm muốn thêm");
        String firm = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm muốn thêm");
        Double price = Double.parseDouble(scanner.nextLine());
        Product product = new Product(code, name, firm, price);
        return product;
    }

    @Override
    public void displayProduct() throws IOException {
        System.out.println("Danh sách sản phẩm là");
        readFile();
        for (int i = 0; i < productList.size(); i++) {
            System.out.println(productList.get(i).getInfo());
        }

    }

    //    private String getInfo(Product product) {
//        return String.format("%s,%s,%s,%s",product.getCode(),product.getName(),product.getFirm(),product.getPrice());
//    }
    @Override
    public void searchProduct() throws IOException {
        System.out.println("Nhập tên sản phẩm muốn tìm");
        readFile();
        String nameSearch = scanner.nextLine();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(nameSearch)) {
                System.out.println("thông tin sản phẩm " + nameSearch + " là: " + productList.get(i));
            } else {
                System.out.println("Sản phẩm không có trong file");
                break;
            }
        }
    }

    public static void readFile() throws IOException {

        try {
            File  file = new File("src\\ss17_IO_binary_file_and_serialization\\exersice\\ss1_product_management\\data\\fileProduct.csv");
            FileInputStream  fileInputStream = new FileInputStream(file);
            ObjectInputStream  objectInputStream = new ObjectInputStream(fileInputStream);
            productList = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File không có gì, hãy tiếp tục chương trình");
        }

    }
}
