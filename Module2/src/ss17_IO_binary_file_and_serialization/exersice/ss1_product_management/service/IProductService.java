package ss17_IO_binary_file_and_serialization.exersice.ss1_product_management.service;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IProductService {
    void addProduct() throws IOException;

    void displayProduct() throws IOException;

    void searchProduct() throws IOException;
}
