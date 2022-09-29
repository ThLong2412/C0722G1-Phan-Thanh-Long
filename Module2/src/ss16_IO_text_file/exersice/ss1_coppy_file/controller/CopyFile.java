package ss16_IO_text_file.exersice.ss1_coppy_file.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) throws IOException {


        File file = new File("src\\ss16_IO_text_file\\exersice\\ss1_coppy_file\\data\\source.csv");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line;
        int count = 0;

        File file1 = new File("src\\ss16_IO_text_file\\exersice\\ss1_coppy_file\\data\\target.csv");

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file1));
        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);
            count += line.length();
            bufferedWriter.newLine();
        }
        bufferedWriter.write("Số ký tự trong file là: " + count);
        bufferedReader.close();
        bufferedWriter.close();

    }
}
