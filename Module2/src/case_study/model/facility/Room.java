package case_study.model.facility;

import case_study.model.facility.Facility;

import java.io.Serializable;

public class Room extends Facility implements Serializable {
    private String freeServiceIncluded;

    public Room() {}

    public Room ( String name,String codeService, String usableArea, String cost, int maxNumberOfPeople, String time,String freeServiceIncluded) {
        super(name,codeService,usableArea,cost,maxNumberOfPeople,time);
        this.freeServiceIncluded = freeServiceIncluded;
    }

    public String getFreeServiceIncluded() {
        return freeServiceIncluded;
    }

    public void setFreeServiceIncluded(String freeServiceIncluded) {
        this.freeServiceIncluded = freeServiceIncluded;
    }

    @Override
    public String toString() {
        return "Room{" +super.toString() +
                ", freeServiceIncluded='" + freeServiceIncluded +
                '}';
    }
    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s,%s",getName(),getCodeService(),getUsableArea(),getCost(),getMaxNumberOfPeople(),getTime(),getFreeServiceIncluded());
    }
}
