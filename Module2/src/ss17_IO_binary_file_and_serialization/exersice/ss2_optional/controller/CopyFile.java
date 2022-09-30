package ss17_IO_binary_file_and_serialization.exersice.ss2_optional.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFile implements Serializable {

    public static void main(String[] args) {

        try {

            File sourceFile = new File("src\\ss17_IO_binary_file_and_serialization\\exersice\\ss2_optional\\data\\source.csv");

            List<String> stringList = new ArrayList<>();
            stringList.add("Thanh Long 2004");
            stringList.add("0384356242");
            stringList.add("Đà Nẵng");


            //viết vào file
            FileOutputStream fileOutputStream1 = new FileOutputStream(sourceFile);
            ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);
            objectOutputStream1.writeObject(stringList);
            objectOutputStream1.close();

            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            // đọc file
            stringList = (List<String>) objectInputStream.readObject();
            objectInputStream.close();

            File targetFile = new File("src\\ss17_IO_binary_file_and_serialization\\exersice\\ss2_optional\\data\\target.csv");
            FileOutputStream fileOutputStream = new FileOutputStream(targetFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(stringList);

            for (String s : stringList) {
                System.out.println(s);
            }
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
//            System.out.println(e.getMessage());
            e.getMessage();
        }
    }
}
