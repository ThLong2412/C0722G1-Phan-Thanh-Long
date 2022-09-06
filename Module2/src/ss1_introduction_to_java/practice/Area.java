package ss1_introduction_to_java.practice;

import java.util.Scanner;

public class Area {
    public static void main(String[] args) {
        float height;
        float width;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter height: ");
        height = scanner.nextFloat();
        System.out.println("Enter width: ");
        width = scanner.nextFloat();
        float area = height * width;
        System.out.println("Area = " + area);
    }
}
