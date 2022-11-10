package repositoy.impl;

import model.Facility;
import repositoy.IFacilityRepository;

import java.util.List;

public class FacilityRepository implements IFacilityRepository {
    private static final String INSERT_FACILITY = "insert into facility values (?,?,?,?,?,?,?,?,?)";
    private static final String SELECT_ALL_FACILITY = "select * from facility";
    private static final String DELETE_FACILITY = "delete from facility where id = ?";
    private static final String UPDATE_FACILITY = "update facility set customer_type_id = ?, name  = ?, day_of_birth = ?, gender = ?, id_card =?, phone_number = ?, email = ?, address = ? where id = ?";
    private static final String GET_FACILITY_BY_NAME = "select * from facility where  name like ?";
    @Override
    public List<Facility> listFacility() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update(Facility facility) {
        return false;
    }

    @Override
    public Facility getFacilityById(int id) {
        return null;
    }

    @Override
    public void add(Facility facility) {

    }

    @Override
    public List<Facility> search(String name) {
        return null;
    }
}
