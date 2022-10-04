package case_study.model.person;

import java.io.Serializable;
import java.time.LocalDate;

public class Employee extends Person implements Serializable { // lớp nhân viên
    private String level;
    private String location;
    private String wage;

    public Employee() {}

    public Employee(String code, String name, LocalDate dayOffBirth, String gender, String idNumbers, String phoneNumbers, String email, String level, String location, String wage) {
        super(code, name, dayOffBirth, gender, idNumbers, phoneNumbers, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWage() {
        return wage;
    }

    public void setWage(String wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "level = " + level +
                ", location = " + location +
                ", wage = " + wage +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",getCode(),getName(),getDayOffBirth(),getGender(),getIdNumbers(),getPhoneNumbers(),getEmail(),getLevel(),getLocation(),getWage());
    }

}
