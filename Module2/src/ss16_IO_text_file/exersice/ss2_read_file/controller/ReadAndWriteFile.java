package ss16_IO_text_file.exersice.ss2_read_file.controller;

import ss16_IO_text_file.exersice.ss2_read_file.model.Nations;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void main(String[] args) throws IOException {
        File file = new File("src\\ss16_IO_text_file\\exersice\\ss1_read_file\\data\\nation.csv");


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }


        String line2;
        List<Nations> nationsList = new ArrayList<>();
        Nations nations;
        String[] info;
        while ((line2 = bufferedReader.readLine()) != null) {
            info = line2.split(",");
            nations = new Nations(Integer.parseInt(info[0]), info[1], info[2]);
            nationsList.add(nations);
        }
        bufferedReader.close();
        for (Nations n : nationsList) {
            System.out.println(n);
        }
    }
}
