package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IProductService {
    private static final Map<Integer,Product> productList = new HashMap<>();
    static {
        productList.put(1,new Product(1,"Sách",45, "SGK", "VN"));
        productList.put(2,new Product(2,"Vở",20, "4 ô ly", "VN"));
        productList.put(3,new Product(3,"Bút",5, "mực xanh", "VN"));
        productList.put(4,new Product(4,"Thước",10, "30cm", "VN"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void save(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
    productList.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        productList.remove(id);
    }

    @Override
    public Map<Integer,Product> search(int id) {
        Map<Integer,Product> map = new HashMap<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId()==id) {
                map.put(productList.get(i).getId(),productList.get(id));
                return map;
            }
        }
        return map;
    }


}
