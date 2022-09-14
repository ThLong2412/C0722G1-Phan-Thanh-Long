package ss7_interface_and_abstract_class.exersice.ss2_colorable;

import ss7_interface_and_abstract_class.exersice.ss1_resizeable.Rectangle7;
import ss7_interface_and_abstract_class.exersice.ss1_resizeable.Square7;

public class Square72 extends Rectangle7 implements Colorable {
    public void howToColor() {
        System.out.println("Color all four sides.");
    }

    public Square72(double side, String color, boolean filled) {
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
        setSide(getSide() + percent * getSide() / 100);
    }

    @Override
    public String toString() {
        return "A Square with side = "
                + getSide()
                + ", which is a subclass of a square with area is a: " + getArea() + ", perimeter is a: " + getPerimeter()
                + ", which is a subclass of " + getColor() + " and " + (isFilled() ? "filled" : "not filled");
    }
}
