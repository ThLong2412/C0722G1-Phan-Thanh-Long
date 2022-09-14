package ss7_interface_and_abstract_class.exersice.ss1_resizeable;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    Resizeable [] resizeables = new Resizeable[3];
    resizeables[0] = new Circle7(2 ,"red");
    resizeables[1] = new Rectangle7(5 ,2,"green",false);
    resizeables[2] =  new Square7(4,"black",true);
        System.out.println("Initial: ");
    for (Resizeable resizeable : resizeables) {
        System.out.println(resizeable);
    }
        System.out.println("After increase");
    if (resizeables[0] instanceof Circle7) {
        resizeables[0].resize(25);
        System.out.println(resizeables[0]);
    }
    if (resizeables[1] instanceof Rectangle7) {
        resizeables[1].resize(10);
        System.out.println(resizeables[1]);
    }
    if (resizeables[2] instanceof Square7) {
        resizeables[2].resize(20);
        System.out.println(resizeables[2]);
    }
    }
}
