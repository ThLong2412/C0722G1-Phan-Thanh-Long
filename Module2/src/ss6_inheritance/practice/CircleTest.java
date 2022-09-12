package ss6_inheritance.practice;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5, "blue", true);
        System.out.println(circle);
    }
}
