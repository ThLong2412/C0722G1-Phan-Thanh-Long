package repositoy;

import model.Customer;
import model.Facility;

import java.util.List;

public interface IFacilityRepository {
    List<Facility> listFacility();
    boolean delete(int id) ;
    boolean update(Facility facility) ;
    Facility getFacilityById(int id) ;
    void add(Facility facility);
    List<Facility> search(String name);
}
