package ss4_class_and_oop_in_java.exersice.fan;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Enter on");
        System.out.println("2. Enter on");
        for (int i = 0; i < 999 ; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            if (number == 1) {
                fan.on = true;
                fan.speed = fan.FAST;
                fan.color = "yellow";
                fan.radius = 10;
                System.out.println(fan.display1());

            }
            if (number == 2) {
                fan.on = false;
                System.out.println(fan.display2());
            }
        }
    }
}

