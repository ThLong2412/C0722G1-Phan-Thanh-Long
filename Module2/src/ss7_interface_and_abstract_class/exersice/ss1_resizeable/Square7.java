package ss7_interface_and_abstract_class.exersice.ss1_resizeable;

public  class Square7 extends Rectangle7 implements Resizeable {
    public Square7() {
    }

    public Square7(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return getWidth();
    }

    public void setSide(double side) {
        setWidth(side);
        setHeight(side);
    }

    public void resize(double percent) {
        setSide(getSide() + percent*getSide()/100);
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + getSide()
                + ", which is a subclass of a square with width = "
                + getWidth() + " and height = " + getHeight()      + ", area is a: " + getArea() + ", perimeter is a: " + getPerimeter()
                + ", which is a subclass of " + getColor() + " and " + (isFilled() ? "filled" : "not filled");

    }
}
