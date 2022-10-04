package case_study.model.facility;

import case_study.model.facility.Facility;

import java.io.Serializable;

public class Villa extends Facility implements Serializable {
    private String villaStandard;
    private String poolArea;
    private int numberFloor;

    public Villa() {}

    public Villa( String name,String codeService, String usableArea, String cost, int maxNumberOfPeople, String time,String villaStandard, String poolArea, int numberRoom) {
        super(name,codeService,usableArea,cost,maxNumberOfPeople,time);
        this.villaStandard = villaStandard;
        this.poolArea = poolArea;
        this.numberFloor = numberRoom;
    }

    public String getVillaStandard() {
        return villaStandard;
    }

    public void setVillaStandard(String villaStandard) {
        this.villaStandard = villaStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(int numberFloor) {
        this.numberFloor = numberFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +super.toString() +
                "villaStandard='" + villaStandard +
                ", poolArea='" + poolArea +
                ", numberRoom=" + numberFloor +
                '}';
    }
}
