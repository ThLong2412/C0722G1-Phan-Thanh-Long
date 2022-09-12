package ss5_access_modifier.exersice.ss1_circle;

public class Circle {
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
        double area = radius *radius * Math.PI;
        return area;
    }
    void display() {
        System.out.println("radius:" + radius +", area: " + getArea());
    }
}
