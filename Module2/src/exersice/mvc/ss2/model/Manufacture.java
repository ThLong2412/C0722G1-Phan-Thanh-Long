package exersice.mvc.ss2.model;

public class Manufacture {
    private static String codeManufacture;
    private static String nameManufacture;
    private static String nation;

    public Manufacture() {
    }

    public Manufacture(String codeManufacture, String nameManufacture, String nation) {
        this.codeManufacture = codeManufacture;
        this.nameManufacture = nameManufacture;
        this.nation = nation;
    }

    public static String getCodeManufacture() {
        return codeManufacture;
    }

    public static void setCodeManufacture(String codeManufacture) {
        Manufacture.codeManufacture = codeManufacture;
    }

    public static String getNameManufacture() {
        return nameManufacture;
    }

    public static void setNameManufacture(String nameManufacture) {
        Manufacture.nameManufacture = nameManufacture;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Manufacture.nation = nation;
    }
}
