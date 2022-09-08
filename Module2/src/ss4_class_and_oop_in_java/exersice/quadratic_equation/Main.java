package ss4_class_and_oop_in_java.exersice.quadratic_equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b =  scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b,c);
        System.out.println(quadraticEquation.display());
        System.out.println("The solution of the equation is: " + quadraticEquation.getFindTest());
    }
}
