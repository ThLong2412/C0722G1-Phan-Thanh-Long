package service;

import model.Facility;

import java.util.List;

public interface IFacilityService {
    List<Facility> listFacility();
    boolean delete(int id) ;
    boolean update(Facility facility) ;
    Facility getFacilityById(int id) ;
    void add(Facility facility);
    List<Facility> search(String name);
}
