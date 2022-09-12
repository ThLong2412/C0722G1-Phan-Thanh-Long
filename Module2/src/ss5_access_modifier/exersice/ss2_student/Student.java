package ss5_access_modifier.exersice.ss2_student;

import sun.applet.AppletResourceLoader;

public class Student {
    private String name = "john";
    private String classes = "C07";

    public Student() {
    }

    public Student(String n, String c) {
        name = n;
        classes = c;
    }

    public String setName(String name) {
        return name;
    }

    public String setClasses(String classes) {
        return classes;
    }

    void display() {
        System.out.println("Name: " + name + ", Class: " + classes);
    }
}
