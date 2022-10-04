package case_study.model.facility;

import java.sql.Timestamp;

public abstract class Facility {
    private String name;
    private String usableArea;
    private String cost;
    private int maxNumberOfPeople;
    private String time;
    private String codeService;

    public Facility() {
    }

    public Facility(String name, String codeService, String usableArea, String cost, int maxNumberOfPeople, String time) {
        this.name = name;
        this.codeService = codeService;
        this.usableArea = usableArea;
        this.cost = cost;
        this.maxNumberOfPeople = maxNumberOfPeople;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public int getMaxNumberOfPeople() {
        return maxNumberOfPeople;
    }

    public void setMaxNumberOfPeople(int maxNumberOfPeople) {
        this.maxNumberOfPeople = maxNumberOfPeople;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return
                "name = " + name +
                 "codeService = " + codeService +
                  ", area = " + usableArea +
                  ", cost = " + cost +
                 ", maxNumberOfPeople = " + maxNumberOfPeople +
                 ", time = " + time
                ;
    }
}
