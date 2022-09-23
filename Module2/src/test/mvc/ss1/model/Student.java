package test.mvc.ss1.model;


public class Student extends Person implements  Comparable<Student >{
    private  String classes;
    private   double score;

    public Student() {
    }

    public Student(String code, String name,String pattern, String gender, String classes, double score) {
        super(code, name, pattern, gender);
        this.classes = classes;
        this.score = score;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return  "Thông tin học sinh là: Student { " + getCode() + ", " + getName() + ", " + getPattern() + ", " + getGender() + ", "
                + getClasses() +", " + getScore() + "}";
    }

    @Override
    public int compareTo(Student o) {
        if (this.getName().compareTo(o.getName()) != 0){
            return this.getName().compareTo(o.getName());
        }
        return this.getCode().compareTo(o.getCode());
    }
}
