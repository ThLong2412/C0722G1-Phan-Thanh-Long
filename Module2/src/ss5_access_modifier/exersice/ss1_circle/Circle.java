package ss5_access_modifier.exersice.ss1_circle;

public class Circle {
    final double PI =  3.14;
    private double radius = 1.0;
    private String coloer = "red";
    public Circle() {
    }
    public Circle (double r) {
        radius = r;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        double area = radius *radius * PI;
        return area;
    }
    void display() {
        System.out.println("radius:" + radius +", area: " + getArea());
    }
}
