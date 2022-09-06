package ss1_introduction_to_java.exercise;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int RATE = 23000;
        System.out.println("Enter USD: ");
        float usd;
        usd = scanner.nextFloat();
        float vnd;
        vnd = RATE * usd;
        System.out.println("VND: " + vnd);
    }
}
