package ss16_IO_text_file.practice.ss2_max.controller;

import java.io.FileNotFoundException;
import java.util.List;

public class FindMaxValue {
    public static int findMax (List<Integer> list) {
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> list = readAndWriteFile.readFile("src\\ss16_IO_text_file\\practice\\ss2_max\\data\\testmax.csv");
        int maxValue = findMax(list);
        readAndWriteFile.writeFile("src\\ss16_IO_text_file\\practice\\ss2_max\\data\\info.csv", maxValue);
    }
}
