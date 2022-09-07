package ss2_loop_in_java.practice;

import java.util.Scanner;

public class InterestRate {
    public static void main(String[] args) {
        double money;
        int month;
        double interestRate;
        Scanner input = new Scanner(System.in);
        System.out.println(" enter loan amount: ");
        money = input.nextDouble();
        System.out.println("monthly interest rate: ");
        interestRate = input.nextDouble();
        System.out.println("enter month: ");
        month = input.nextInt();
        double totalInterest = 0;
        for (int i = 0; i < month; i++) {
            totalInterest += money * (interestRate / 100) / 12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
