package ss2_loop_in_java.exersice;

import java.util.Scanner;

public class PicturePrinting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String text = "";
        switch (number) {
            case 1:
                System.out.println("Enter width: ");
                int width = scanner.nextInt();
                System.out.println("Enter height: ");
                int height = scanner.nextInt();
                for (int i = 1; i <= width; i++) {
                    for (int j = 1; j <= height; j++) {
                        text += "*";
                    }
                    text +="\n";
                }
                System.out.println(text);
                break;
            case 2:
                System.out.println("Enter height: ");
                int height2 = scanner.nextInt();
                for (int i = 1; i <= height2; i++) {
                    for (int j = 1; j <= i ; j++) {
                        text +="*";
                    }
                    text += "\n";
                }
                System.out.println(text);
                break;
            case 3:
                System.out.println("Enter height: ");
                int height3 = scanner.nextInt();
                for (int i = 1; i <= height3; i++) {
                    for (int j = i; j <= height3; j++) {
                        text +="* ";
                    }
                    text += "\n";
                }
                System.out.println(text);
                break;
        }
    }
}
