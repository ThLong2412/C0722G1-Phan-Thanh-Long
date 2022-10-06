package case_study.model;

import java.time.LocalDate;

public class Booking {
    private String codeBooking;
    private LocalDate dayStart;
    private LocalDate dayEnd;
    private String codeCustomer;
    private String codeService;
    private String typeOfService;

    public Booking( ){}

    public Booking(String codeBooking, LocalDate dayStart, LocalDate dayEnd, String codeCustomer, String codeService, String typeOfService) {
        this.codeBooking = codeBooking;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.codeCustomer = codeCustomer;
        this.codeService = codeService;
        this.typeOfService = typeOfService;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public LocalDate getDayStart() {
        return dayStart;
    }

    public void setDayStart(LocalDate dayStart) {
        this.dayStart = dayStart;
    }

    public LocalDate getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(LocalDate dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", dayStart='" + dayStart + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", codeService='" + codeService + '\'' +
                ", typeOfService='" + typeOfService + '\'' +
                '}';
    }

    public String getInfo() {
        return String.format("%s,%s,%s,%s,%s,%s",getCodeBooking(),getDayStart(),getDayEnd(),getCodeCustomer(),getCodeService(),getTypeOfService());
    }
}
