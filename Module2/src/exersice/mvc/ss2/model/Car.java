package exersice.mvc.ss2.model;

public class Car {
    private static String seaOfControl;
    private static String yearOfManufacture;
    private static String owner;

    public Car() {
    }

    public Car (String seaOfControl, String yearOfManufacture, String owner) {
        this.seaOfControl = seaOfControl;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public static String getSeaOfControl() {
        return seaOfControl;
    }

    public static void setSeaOfControl(String seaOfControl) {
        Car.seaOfControl = seaOfControl;
    }

    public static String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public static void setYearOfManufacture(String yearOfManufacture) {
        Car.yearOfManufacture = yearOfManufacture;
    }

    public static String getOwner() {
        return owner;
    }

    public static void setOwner(String owner) {
        Car.owner = owner;
    }

}
