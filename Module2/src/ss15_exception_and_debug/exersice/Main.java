package ss15_exception_and_debug.exersice;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
        TriangleEdgesCheck triangleEdgesCheck = new TriangleEdgesCheck();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            double a;
            double b;
            double c;
            while (true) {
                System.out.print("Nhập cạnh thứ nhất");
                a = scanner.nextDouble();
                try {
                    triangleEdgesCheck.checkTriangleEdge1(a);
                    break;
                } catch (TriangleEdgesException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                System.out.print("Nhập cạnh thứ hai");
                b = scanner.nextDouble();
                try {
                    triangleEdgesCheck.checkTriangleEdge1(b);
                    break;
                } catch (TriangleEdgesException e) {
                    System.out.println(e.getMessage());
                }
            }
            while (true) {
                System.out.print("Nhập cạnh thứ ba");
                c = scanner.nextDouble();
                try {
                    triangleEdgesCheck.checkTriangleEdge1(c);
                    break;
                } catch (TriangleEdgesException e) {
                    System.out.println(e.getMessage());
                }
            }
            try {
                triangleEdgesCheck.checkTriangleEdge(a, b, c);
                break;
            } catch (TriangleEdgesException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
