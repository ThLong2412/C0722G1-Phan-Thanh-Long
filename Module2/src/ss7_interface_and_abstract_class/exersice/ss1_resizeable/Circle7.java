package ss7_interface_and_abstract_class.exersice.ss1_resizeable;

public class Circle7 implements Resizeable {
    private double radius;
    private String color;

    public Circle7() {
    }

    public Circle7(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
    public void resize(double percent) {
        setRadius(getRadius() + percent*getRadius()/100);
    }
    @Override
    public String toString( ) {
        return "A Circle with radius = " + radius
                + ", color = " + color
                + " and "
                + " A area is a: " + getArea();
    }
}
