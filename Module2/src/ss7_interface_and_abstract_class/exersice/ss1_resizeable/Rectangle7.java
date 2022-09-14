package ss7_interface_and_abstract_class.exersice.ss1_resizeable;

import ss6_inheritance.practice.Shape;

public class Rectangle7 extends Shape implements Resizeable {
    private double width = 1.0;
    private double height = 1.0;

    public Rectangle7() {
    }

    public Rectangle7(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }


    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return this.height * this.width;
    }

    public double getPerimeter() {
        return (this.height + this.width) * 2;
    }
    public void resize(double percent) {
        setWidth(getWidth() + percent*getWidth()/100);
        setHeight(getHeight() + percent*getHeight()/100);
    }
    @Override
    public String toString() {
        return "A Rectangle with width = "
                + getWidth()
                + " and height = "
                + getHeight()
                + ", area is a: " + getArea() + ", perimeter is a: " + getPerimeter()
                + ", which is a subclass of "
                + super.toString();
    }
}
