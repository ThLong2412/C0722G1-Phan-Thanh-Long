package test.mvc.ss1.model;

public class Person {
    private  String code;
    private  String name;
    private  String pattern;
    private  String gender;

    public Person(){
    }

    public Person(String code, String name,String pattern, String gender) {
        this.code = code;
        this.name =  name;
        this.pattern = pattern;
        this.gender = gender;
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

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
