package com.codegym.reposotory.impl;

import com.codegym.model.Product;
import com.codegym.reposotory.IProductRepository;
import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

//    private static final Map<Integer,Product> productList = new HashMap<>();
//    static {
//        productList.put(1,new Product(1,"Sách",45, "SGK", "VN"));
//        productList.put(2,new Product(2,"Vở",20, "4 ô ly", "VN"));
//        productList.put(3,new Product(3,"Bút",5, "mực xanh", "VN"));
//        productList.put(4,new Product(4,"Thước",10, "30cm", "VN"));
//    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void save(Product product) {
//        productList.put(product.getId(),product);
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :id").setParameter("id", id).getSingleResult();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(int id, Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void remove(Product product) {
//        productList.remove(id);
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> search(String name) {
//        List<Product> products = new ArrayList<>();
//        for(Product product : productList.values()) {
//            if (product.getName().contains(name)) {
//                products.add(product);
//            }
//        }
//        return products;
        Session session = null;
//        Product product = null;
        List<Product> productList = new ArrayList<>();
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product where name like :name").setParameter("name", "%" + name + "%").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }
}
