package ss15_exception_and_debug.exersice;

public class TriangleEdgesCheck {
    public void checkTriangleEdge (double a, double b, double c) throws TriangleEdgesException {
        if (a + b < c || a + c < b || b + c < a){
            throw new TriangleEdgesException("Tam giác không hợp lệ");
        }
        else {
            System.out.println("Tam giác đúng đó chú em");
        }
    }
    public void checkTriangleEdge1 (double x) throws TriangleEdgesException {
        if (x < 0) {
            throw new TriangleEdgesException("Cạnh không hợp lệ");
        } else {
            System.out.println("cạnh đúng rồi nha");
        }
    }
}
