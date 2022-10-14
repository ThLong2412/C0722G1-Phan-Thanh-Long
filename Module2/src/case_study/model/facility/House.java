package case_study.model.facility;

import java.io.Serializable;

public class House  extends Facility implements Serializable {
    private String standard;
    private int numberFloor;

    public House() {}

    public House( String name,String codeService, String usableArea, String cost, int maxNumberOfPeople, String time,String standard, int numberFloor) {
        super(name,codeService,usableArea,cost,maxNumberOfPeople,time);
        this.standard = standard;
        this.numberFloor = numberFloor;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "House{" +super.toString() +
                ", houseStandard='" + standard + '\'' +
                ", numberFloor=" + numberFloor +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",getName(),getCodeService(),getUsableArea(),getCost(),getMaxNumberOfPeople(),getTime(),getStandard(),getNumberFloor());
    }
}
