package furama_resort.model;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int numberFloors;

    public Villa() {
    }

    public Villa(String serviceCode,String serviceName, double areaUse, double rentaClosts, int people, String rentalType, String roomStandard, double poolArea, int numberFloors) {
        super(serviceCode,serviceName, areaUse, rentaClosts, people, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
