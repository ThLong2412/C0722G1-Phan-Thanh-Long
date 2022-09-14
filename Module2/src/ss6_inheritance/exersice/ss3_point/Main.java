package ss6_inheritance.exersice.ss3_point;

public class Main {
    public static void main(String[] args) {
//        Point point = new Point();
//        point = new Point(10,20);
//        System.out.println(point);
        MoveablePoint moveablePoint = new MoveablePoint();
        moveablePoint = new MoveablePoint(1,2,2,4);
        System.out.println(moveablePoint);
        System.out.println(moveablePoint.move());
        System.out.println(moveablePoint.move());
    }
}
