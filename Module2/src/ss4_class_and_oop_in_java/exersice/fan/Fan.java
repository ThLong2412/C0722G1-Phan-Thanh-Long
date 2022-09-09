package ss4_class_and_oop_in_java.exersice.fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    int speed = SLOW;
    boolean on = false;
    double radius = 5;
    String color = "blue";
    public Fan () {
    }
    public Fan(int speed, boolean on, double radius, String color ) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }
    public int getSpeed() {
        return this.speed;
    }
    public boolean getOn() {
        return this.on;
    }
    public double getRadius() {
        return this.radius;
    }
    public String getColor() {
        return this.color;
    }
    public String display1() {
        return "the state of the is: " + getSpeed() + ", " + getColor() + ", " + getRadius() + ", " + "fan is on.";
    }
    public String display2() {
        return "the state of the fan is: " + getColor() + ", " + getRadius() + ", " + "fan is off.";
    }
}
