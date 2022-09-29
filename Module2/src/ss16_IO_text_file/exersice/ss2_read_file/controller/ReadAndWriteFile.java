package ss16_IO_text_file.exersice.ss2_read_file.controller;

import ss16_IO_text_file.exersice.ss2_read_file.model.Nations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args){
        try {
            File file = new File("src\\ss16_IO_text_file\\exersice\\ss2_read_file\\data\\nation.csv");

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            List <Nations> nationsList = new ArrayList<>();
            Nations nations;
            String[] info;
            System.out.println("Danh sách các quốc gia");
            while ((line = bufferedReader.readLine()) != null) {
                info = line.split(",");
                nations = new Nations(Integer.parseInt(info[0]), info[1], info[2]);
                nationsList.add(nations);
            }
            bufferedReader.close();

        for (Nations n : nationsList) {
            System.out.println(n.getInfo());
        }
        } catch (IOException e) {
            System.out.println(" lỗi rồi nháaa");
        }
    }
}
