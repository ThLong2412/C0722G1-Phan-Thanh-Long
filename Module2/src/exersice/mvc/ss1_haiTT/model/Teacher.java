package exersice.mvc.ss1_haiTT.model;

public class Teacher extends Person implements Comparable<Teacher> {
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

    @Override
    public int compareTo(Teacher o) {
        if (this.getName().compareTo(o.getName()) != 0) {
            return this.getName().compareTo(o.getName());
        }
        return this.getCode().compareTo(o.getCode());
    }
}
