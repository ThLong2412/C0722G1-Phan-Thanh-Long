package ss2_loop_in_java.practice;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number1: ");
        int number1 = scanner.nextInt();
        System.out.println("Enter number2: ");
        int number2 = scanner.nextInt();
        number1 = Math.abs(number1);
        number2 = Math.abs(number2);
        if (number1 == 0 && number2 == 0) {
            System.out.println("No greatest common factor");
        }
        if (number1 == 0 && number2 != 0) {
            System.out.println("Greatest common factor: " + number2);
        }
        if (number1 != 0 && number2 == 0) {
            System.out.println("Greatest common factor: " + number1);
        }
    }
}

