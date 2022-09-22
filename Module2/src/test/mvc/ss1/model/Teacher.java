package test.mvc.ss1.model;

public class Teacher extends Person {
    private String specializes;

    public Teacher() {
    }

    public Teacher(String code, String name, String pattern, String gender, String specializes) {
        super(code, name, pattern, gender);
        this.specializes = specializes;
    }

    public String getSpecializes() {
        return specializes;
    }

    public void setSpecializes(String specializes) {
        this.specializes = specializes;
    }

    @Override
    public String toString() {
        return "Teacher{" + getCode() +", " + getName() +", " +getPattern() +", " + getGender() +", " + getSpecializes() +"}";
    }
}
