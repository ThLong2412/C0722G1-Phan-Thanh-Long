package ss6_inheritance.exersice.ss3_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point();
        point = new Point(10,20);
        System.out.println(point);
        MoveablePoint moveablePoint = new MoveablePoint();
        moveablePoint = new MoveablePoint(1,2);
        System.out.println(moveablePoint);
    }
}
