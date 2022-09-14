package ss6_inheritance.exersice.ss1_circle;

public class Cylinder  extends Circle {
    private  double height;
    public Cylinder() {
    }
    public Cylinder (double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return super.toString() + ", height is a: " + height + ", Volume is a: " + getVolume();
    }
}
