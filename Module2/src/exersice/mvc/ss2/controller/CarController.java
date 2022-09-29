package exersice.mvc.ss2.controller;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class CarController {
    public static void main(String[] args) {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----Bạn muốn quản lý loại xe nào-----");
            System.out.println("1. Xe tải");
            System.out.println("2. Oto");
            System.out.println("3. Xe máy");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

            }
        }
    }

}
