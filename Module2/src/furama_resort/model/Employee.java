package furama_resort.model;

public class Employee extends Person{
    private String level;
    private String position;
    private double wage;

    public Employee() {
    }

    public Employee(int id, String name, String birthday, String gender, String identityCard, String phoneNumber, String email, String level, String position, double wage) {
        super(id, name, birthday, gender, identityCard, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    @Override
    public String toString() {
        return "Employee{" +super.toString()+
                "level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", wage=" + wage +
                '}';
    }
    public String getInfo(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",getId(),getName(),getBirthday(),getGender(),getIdentityCard(),getPhoneNumber(),getEmail(),getLevel(),getPosition(),getWage());
    }
}
