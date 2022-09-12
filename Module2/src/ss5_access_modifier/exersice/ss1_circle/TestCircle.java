package ss5_access_modifier.exersice.ss1_circle;


import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        Circle circle1 = new Circle(scanner.nextDouble());
        circle1.display();
    }
}
