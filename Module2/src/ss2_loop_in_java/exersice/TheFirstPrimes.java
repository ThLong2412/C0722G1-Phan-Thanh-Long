package ss2_loop_in_java.exersice;

import java.util.Scanner;

public class TheFirstPrimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of primes to print: ");
        int numbers = scanner.nextInt();
        int number = 2;
        int count = 0;
        int check = 0;
        String text = "";
        while (count < numbers) {
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    check++;
                }
            }
            if (check == 2) {
                count++;
                text += number + ", ";
            }
            number++;
            check = 0;
        }
        System.out.println(numbers + " the first prime number is: " + text);
    }
}
