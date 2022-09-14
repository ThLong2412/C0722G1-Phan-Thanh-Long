package ss7_interface_and_abstract_class.exersice.ss2_colorable;

public class Main {
    public static void main(String[] args) {
        Colorable [] colorables = new Colorable[4];
        colorables[0] = new Square72(1,"red",true);
        colorables[1] = new Square72(2,"pink",false);
        colorables[2] = new Square72(3,"yellow",true);
        colorables[3] = new Square72(4,"black",false);
        for (int i = 0; i < colorables.length; i ++) {
            System.out.println(colorables[i]);
            if (colorables[i] instanceof Square72) {
                colorables[i].howToColor();
            }
        }
    }
}
