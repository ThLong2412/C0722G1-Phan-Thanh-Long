package model;

public class Facility {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int max_people;
    private int rent_type_id;
    private int facility_type_id;
    private String standard_room;
    private String description_other_convenience;
    private int pool_area;
    private int numbers_of_floors;
    private String facility_free;

    public Facility() {
    }

    public Facility(int id, String name, int area, double cost, int max_people, int rent_type_id, int facility_type_id, String standard_room, String description_other_convenience, int pool_area, int numbers_of_floors, String facility_free) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.max_people = max_people;
        this.rent_type_id = rent_type_id;
        this.facility_type_id = facility_type_id;
        this.standard_room = standard_room;
        this.description_other_convenience = description_other_convenience;
        this.pool_area = pool_area;
        this.numbers_of_floors = numbers_of_floors;
        this.facility_free = facility_free;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMax_people() {
        return max_people;
    }

    public void setMax_people(int max_people) {
        this.max_people = max_people;
    }

    public int getRent_type_id() {
        return rent_type_id;
    }

    public void setRent_type_id(int rent_type_id) {
        this.rent_type_id = rent_type_id;
    }

    public int getFacility_type_id() {
        return facility_type_id;
    }

    public void setFacility_type_id(int facility_type_id) {
        this.facility_type_id = facility_type_id;
    }

    public String getStandard_room() {
        return standard_room;
    }

    public void setStandard_room(String standard_room) {
        this.standard_room = standard_room;
    }

    public String getDescription_other_convenience() {
        return description_other_convenience;
    }

    public void setDescription_other_convenience(String description_other_convenience) {
        this.description_other_convenience = description_other_convenience;
    }

    public int getPool_area() {
        return pool_area;
    }

    public void setPool_area(int pool_area) {
        this.pool_area = pool_area;
    }

    public int getNumbers_of_floors() {
        return numbers_of_floors;
    }

    public void setNumbers_of_floors(int numbers_of_floors) {
        this.numbers_of_floors = numbers_of_floors;
    }

    public String getFacility_free() {
        return facility_free;
    }

    public void setFacility_free(String facility_free) {
        this.facility_free = facility_free;
    }
}
