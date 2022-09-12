package ss5_access_modifier.practice;

import ss5_access_modifier.practice.Student;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();
        Student student1 = new Student(001, "Long");
        student1.display();
        Student student2 = new Student(002, "Thuận");
        student2.display();
    }
}
