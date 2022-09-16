package test.mvc.model;

public class Person {
    private static String code;
    private static String name;
    private static String pattern;
    private static String gender;

    public Person(){
    }

    public Person(String code, String name,String pattern, String gender) {
        this.code = code;
        this.name =  name;
        this.pattern = pattern;
        this.gender = gender;
    }

    public static String getCode() {
        return code;
    }

    public static void setCode(String code) {
        Person.code = code;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Person.name = name;
    }

    public static String getPattern() {
        return pattern;
    }

    public static void setPattern(String pattern) {
        Person.pattern = pattern;
    }

    public static String getGender() {
        return gender;
    }

    public static void setGender(String gender) {
        Person.gender = gender;
    }


}
