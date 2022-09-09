package ss4_class_and_oop_in_java.exersice.fan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        if (fan1.getOn()) {
            fan1.speed = fan1.FAST;
            fan1.color = "yellow";
            fan1.radius = 10;
            System.out.println(fan1.display1());
        }
        if (!fan1.getOn()) {
            System.out.println(fan1.display2());
        }
    }
}
