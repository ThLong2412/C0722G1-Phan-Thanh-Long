package ss6_inheritance.practice;

import ss7_interface_and_abstract_class.exersice.ss1_resizeable.Resizeable;

public  class Circle2 extends Shape  {
    private double radius;

    public Circle2() {
        radius = 1.0;
    }

    public Circle2(double radius) {
        this.radius = radius;
    }

    public Circle2(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return radius * radius * Math.PI;
    }
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }
    @Override
    public String toString() {
        return  "A Circle with radius = "
                + getRadius() + ", area is a: " + getArea() + ", perimeter is a: " + getPerimeter()
                + ", which is a subclass of "
                + super.toString();
    }
}
