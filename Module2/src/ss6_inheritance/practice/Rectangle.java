package ss6_inheritance.practice;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double height = 1.0;
    public Rectangle() {
    }
    public Rectangle (double width, double height, String color, boolean filled) {
        super(color,filled);
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
