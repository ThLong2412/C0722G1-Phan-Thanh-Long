package ss7_interface_and_abstract_class.practice;

public class Chicken extends Animal implements Edible  {
    public String makeSound() {
        return "Chicken: cluck-cluck!";
    }
    public String howtoEat() {
        return "could be fried";
    }
}

