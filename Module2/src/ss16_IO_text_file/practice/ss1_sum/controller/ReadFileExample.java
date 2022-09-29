package ss16_IO_text_file.practice.ss1_sum.controller;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void readTextFile(String filePath) {
        try {
            // đọc file theo đường dẫn filePath
            File file = new File(filePath);
            // kiểm tra file cso tồn tại ko
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = "";
            int sum = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Tổng = " + sum);
        } catch (IOException e) {
            System.out.println("File không tồn tại hoặc nội dung có lỗi");
        }
    }

    public static void main(String[] args) {
        ReadFileExample readFileExample = new ReadFileExample();
        readFileExample.readTextFile("src\\ss16_IO_text_file\\practice\\ss1_sum\\data\\test.csv");
    }
}
