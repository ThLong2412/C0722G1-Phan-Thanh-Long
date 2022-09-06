package ss2_loop_in_java.exersice;

import java.util.Scanner;

public class PicturePrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle ");
        System.out.println("3. Print isosceles triangle");
        int number = scanner.nextInt();
        switch (number) {
            case 1:
                String text = "";
                System.out.println("Enter width: ");
                int width = scanner.nextInt();
                System.out.println("Enter height: ");
                int height = scanner.nextInt();
                for (int i = 1; i <= width; i++) {
                    for (int j = 1; j <= height; j++) {
                        text += "*";
                    }
                    text += "\n";
                }
                System.out.println(text);
                break;
            case 2:
                String text2 = "";
                System.out.println("Enter height2: ");
                int height2 = scanner.nextInt();
                for (int i = 1; i <= height2; i++) {
                    for (int j = 1; j <= i; j++) {
                        text2 += "*";
                    }
                    text2 += "\n";
                }
                System.out.println();
                for (int i = 1; i <= height2; i++) {
                    for (int j = height2; j >= i; j--) {
                        text2 += "*";
                    }
                    text2 += "\n";
                }
                System.out.println();
                for (int i = 1; i <= height2; i++) {
                    for (int j = 1; j <= i; j++) {
                        text2 += " ";
                    }
                    for (int j = height2; j >= i; j--) {
                        text2 += "*";
                    }
                    text2 += "\n";
                }
                System.out.println();
                for (int i = 1; i <= height2; i++) {
                    for (int j = height2; j >= i; j--) {
                        text2 += " ";
                    }
                    for (int j = 1; j <= i; j++) {
                        text2 += "*";
                    }
                    text2 += "\n";
                }
                System.out.println(text2);
                break;
            case 3:
                String text3 = "";
                System.out.println("Enter height3: ");
                int height3 = scanner.nextInt();
                for (int i = 1; i <= height3; i++) {
                    for (int j = height3; j >= i; j--) {
                        text3 += " ";
                    }
                    for (int j = 1; j <= i * 2 - 1; j++) {
                        text3 += "*";
                    }
                    text3 += "\n";
                }
                System.out.println(text3);
                break;
        }
    }
}
