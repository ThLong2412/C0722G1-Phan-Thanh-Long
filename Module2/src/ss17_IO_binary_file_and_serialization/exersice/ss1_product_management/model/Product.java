package ss17_IO_binary_file_and_serialization.exersice.ss1_product_management.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int code;
    private String name;
    private String firm;
    private double price;

    public Product() {
    }

    public Product(int code, String name, String firm, double price) {
        this.code = code;
        this.name = name;
        this.firm = firm;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s",getCode(),getName(),getFirm(),getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "code = " + code +
                ", name = '" + name + '\'' +
                ", firm = '" + firm + '\'' +
                ", price = " + price +
                '}';
    }
}
