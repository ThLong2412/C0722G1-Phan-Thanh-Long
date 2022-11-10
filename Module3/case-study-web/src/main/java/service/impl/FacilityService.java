package service.impl;

import model.Facility;
import repositoy.IFacilityRepository;
import repositoy.impl.FacilityRepository;
import service.IFacilityService;

import java.util.List;

public class FacilityService implements IFacilityService {
    private IFacilityRepository facilityRepository = new FacilityRepository();
    @Override
    public List<Facility> listFacility() {
        return facilityRepository.listFacility();
    }

    @Override
    public boolean delete(int id) {
        return facilityRepository.delete(id);
    }

    @Override
    public boolean update(Facility facility) {
        return facilityRepository.update(facility);
    }

    @Override
    public Facility getFacilityById(int id) {
        return facilityRepository.getFacilityById(id);
    }

    @Override
    public void add(Facility facility) {
        facilityRepository.add(facility);
    }

    @Override
    public List<Facility> search(String name) {
        return facilityRepository.search(name);
    }
}
