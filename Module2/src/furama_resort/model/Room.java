package furama_resort.model;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String serviceCode,String serviceName, double areaUse, double rentaClosts, int people, String rentalType, String freeService) {
        super(serviceCode,serviceName, areaUse, rentaClosts, people, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +super.toString()+
                "freeService='" + freeService + '\'' +
                '}';
    }
}
