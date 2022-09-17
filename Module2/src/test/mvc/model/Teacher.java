package test.mvc.model;

public class Teacher extends Person {
    private static String specializes;

    public Teacher() {
    }

    public Teacher(String code, String name, String pattern, String gender, String specializes) {
        super(code, name, pattern, gender);
        this.specializes = specializes;
    }

    public static String getSpecializes() {
        return specializes;
    }

    public static void setSpecializes(String specializes) {
        Teacher.specializes = specializes;
    }

    @Override
    public String toString() {
        return "Teacher{" + getCode() +", " + getName() +", " +getPattern() +", " + getGender() +", " + getSpecializes() +"}";
    }
}
