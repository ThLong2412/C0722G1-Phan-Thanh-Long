package test.mvc.ss1.model;


public class Student extends Person{
    private static String classes;
    private static  double score;

    public Student() {
    }

    public Student(String code, String name,String pattern, String gender, String classes, double score) {
        super(code, name, pattern, gender);
        this.classes = classes;
        this.score = score;
    }

    public static String getClasses() {
        return classes;
    }

    public static void setClasses(String classes) {
        Student.classes = classes;
    }

    public static double getScore() {
        return score;
    }

    public static void setScore(double score) {
        Student.score = score;
    }

    @Override
    public String toString() {
        return  "Thông tin học sinh là: Student { " + getCode() + ", " + getName() + ", " + getPattern() + ", " + getGender() + ", "
                + getClasses() +", " + getScore() + "}";
    }

}
