package ss6_inheritance.exersice.ss1_circle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Circle circle =new Circle();
        circle = new Circle(2.5, "red");
        System.out.println(circle);
        Cylinder cylinder = new Cylinder();
        cylinder = new Cylinder(3,5,"yellow");
        System.out.println(cylinder);
    }
}
