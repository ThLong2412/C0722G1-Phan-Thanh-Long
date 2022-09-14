package ss6_inheritance.practice;

public class CircleTest {
    public static void main(String[] args) {
        Circle2 circle = new Circle2();
        System.out.println(circle);
        circle = new Circle2(3.5, "blue", true);
        System.out.println(circle);
    }
}
