package ss4_class_and_oop_in_java.exersice.fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1: Enter on.");
        System.out.println("2: Enter off.");
        int number = Integer.parseInt(scanner.nextLine());
        Fan fan = new Fan();
        if (fan.getOn()) {
            System.out.println(fan.display1());
        } if(!fan.getOn()) {
            System.out.println(fan.display2());
        }
    }
}
