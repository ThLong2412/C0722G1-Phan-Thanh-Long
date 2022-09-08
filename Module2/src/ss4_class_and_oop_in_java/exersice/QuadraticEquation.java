package ss4_class_and_oop_in_java.exersice;

public class QuadraticEquation {
    double a, b, c;

    public QuadraticEquation() {

    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant() {
        double delta = (Math.pow(this.b,2) - 4 * this.a * this.c);
        return delta;
    }
    public double getRoot1() {
        double root1 = (-this.b + Math.sqrt(getDiscriminant()) / (2 * this.a));
        return root1;
    }
    public double getRoot2() {
        double root2 = (-this.b - Math.sqrt(getDiscriminant()) / (2 * this.a));
        return root2;
    }
    public String display () {
        return "Your equation is: " + a +"x^2 + " + b +"x + " + c + " = 0";
    }
    public String getFindTest() {
        String result = "";
        if (getDiscriminant() > 0) {
            result = "The equation with two solutions is: " + getRoot1() + " and " + getRoot2();
        }
        if (getDiscriminant() == 0) {
            result = "The equation with a double solution is: " + getRoot1();
        }
        if (getDiscriminant() < 0) {
            result = "the equation has no solution.";
        }
        return  result;
    }
}
