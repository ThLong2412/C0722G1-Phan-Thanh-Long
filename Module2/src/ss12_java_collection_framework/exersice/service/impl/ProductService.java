package ss12_java_collection_framework.exersice.service.impl;

import ss12_java_collection_framework.exersice.model.Product;
import ss12_java_collection_framework.exersice.service.IProductService;

import java.util.*;

public class ProductService implements IProductService {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Product> productList = new ArrayList<>();

    public Product infoProduct() {
        System.out.println("nhập id sản phẩm");
        String idNew = scanner.nextLine();
        System.out.println("nhập tên sản phẩm");
        String nameNew = scanner.nextLine();
        System.out.println("nhập giá sản phẩm");
        int priceNew = Integer.parseInt(scanner.nextLine());

        Product product = new Product(idNew, nameNew, priceNew);
        return product;
    }

    public void addProduct() {
        Product product = this.infoProduct();
        productList.add(product);
        System.out.println("đã thêm mới thành công");
    }

    @Override
    public void editProduct() {
        System.out.println("nhập id muốn sửa");
        String id1 = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id1)) {
                System.out.println("nhập id mới");
                String idEdit = scanner.nextLine();
                productList.get(i).setId(idEdit);
                System.out.println("nhập tên mới");
                String nameEdit = scanner.nextLine();
                productList.get(i).setName(nameEdit);
                System.out.println("nhập giá của sản phẩm muốn sửa");
                int priceEdit = Integer.parseInt(scanner.nextLine());
                productList.get(i).setPrice(priceEdit);
                System.out.println("đã sửa thành công");
                flag = true;
                break;
            }
            if (!flag){
                System.out.println("không tìm thấy sản phẩm");
            }
        }
    }

    @Override
    public void removeProduct() {
        System.out.println("nhập id sản phẩm cần xóa");
        String idRemove = scanner.nextLine();
        boolean flagDelete = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(idRemove)) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm này không? Nhập Y: yes, N: no");
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    productList.remove(i);
                    System.out.println("Xóa thành công");
                }
                flagDelete = true;
                break;
            }
        } if (!flagDelete) {
            System.out.println("Không tìm thấy đối tượng cần xóa.");
        }
    }

    @Override
    public void displayProduct() {
        System.out.println("danh sách sản phẩm là: ");
        for (Product product : productList) {
            System.out.println( product);
        }
    }

    @Override
    public void findProduct() {
        System.out.println("nhập tên sản phẩm muốn tìm");
        String nameFind = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(nameFind)) {
                System.out.println(productList.get(i));
                flag =true;
                break;
            }
            if (!flag) {
                System.out.println("không tìm thấy sản phẩm đó.");
            }
        }
    }

    @Override
    public void sortProduct() {
        System.out.println("mời bạ chọn thứ tự sắp xếp");
        System.out.println("1. sắp xếp theo thứ tự tăng dần giá sản phẩm");
        System.out.println("2. sắp xếp theo thứ tự giảm dần giá sản phẩm");

        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                Collections.sort(productList, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() > o2.getPrice()) {
                            return 1;
                        } else if (o1.getPrice() < o2.getPrice()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (Product product : productList) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                Collections.sort(productList, new Comparator<Product>() {
                    @Override
                    public int compare(Product o1, Product o2) {
                        if (o1.getPrice() > o2.getPrice()) {
                            return -1;
                        } else if (o1.getPrice() < o2.getPrice()) {
                            return 1;
                        } else {
                            return 0;
                        }
                    }
                });
                for (Product product : productList) {
                    System.out.println(product.toString());
                }
                break;
        }
    }
}
