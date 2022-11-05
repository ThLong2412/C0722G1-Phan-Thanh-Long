package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {

    private static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(102, "Mec ARG","1600000000","Màu Đen","Mercedes-Benz"));
        productList.add(new Product(203, "Mec G63","13000000000","Màu Đen","Mercedes-Benz"));
        productList.add(new Product(304, "Lexus RX350","4200000000","Màu Trắng","Lexus"));
    }
    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id,Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.set(i, product);
            }
        }
    }

    @Override
    public void remove(int id) {

        for (int i = 0; i < productList.size() ; i++) {
            if (productList.get(i).getId() == id){
                productList.remove(productList.get(i));
            }
        }
    }

    @Override
    public Product viewProduct(int id) {
       return productList.get(id);
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }
}
