package case_study.model.person;

import java.time.LocalDate;

public abstract class Person {
    private String code;
    private String name;
    private LocalDate dayOffBirth;
    private String gender;
    private String idNumbers; // số CMND
    private String phoneNumbers;
    private String email;

    public Person() {
    }

    public Person(String code, String name, LocalDate dayOffBirth, String gender, String idNumbers, String phoneNumbers, String email) {
        this.code = code;
        this.name = name;
        this.dayOffBirth = dayOffBirth;
        this.gender = gender;
        this.idNumbers = idNumbers;
        this.phoneNumbers = phoneNumbers;
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDayOffBirth() {
        return dayOffBirth;
    }

    public void setDayOffBirth(LocalDate dayOffBirth) {
        this.dayOffBirth = dayOffBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNumbers() {
        return idNumbers;
    }

    public void setIdNumbers(String idNumbers) {
        this.idNumbers = idNumbers;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "code = " + code  +
                ", name = " + name +
                ", dayOffBirth = " + dayOffBirth +
                ", gender = " + gender +
                ", idNumbers = " + idNumbers +
                ", phoneNumbers = " + phoneNumbers +
                ", email = " + email
                ;
    }

}
