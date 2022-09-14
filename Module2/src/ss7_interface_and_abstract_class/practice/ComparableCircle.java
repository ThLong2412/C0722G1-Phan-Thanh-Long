package ss7_interface_and_abstract_class.practice;


import ss6_inheritance.exersice.ss1_circle.Circle;
import ss6_inheritance.practice.Circle2;

public class ComparableCircle extends Circle2 {
    public interface Comparable {
    }
    public ComparableCircle (double radius) {
        super(radius);
    }
    public ComparableCircle (double radius, String color, boolean filled) {
        super(radius, color, filled);
    }
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
