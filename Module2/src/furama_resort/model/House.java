package furama_resort.model;

public class House extends Facility{
    private String roomStandard;
    private int numberFloors;

    public House() {
    }

    public House(String serviceCode,String serviceName, double areaUse, double rentaClosts, int people, String rentalType, String roomStandard, int numberFloors) {
        super(serviceCode,serviceName, areaUse, rentaClosts, people, rentalType);
        this.roomStandard = roomStandard;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
