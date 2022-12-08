package com.codegym.demo.service.impl.facility;

import com.codegym.demo.model.facility.Facility;
import com.codegym.demo.repository.facility.IFacilityRepository;
import com.codegym.demo.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;
    @Override
    public Page<Facility> findAll(Pageable pageable) {
        return facilityRepository.findAll(pageable);
    }

    @Override
    public Optional<Facility> findByTd(Long id) {
        return facilityRepository.findById(id);
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void remove(Long id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Page<Facility> search(Pageable pageable, String name, String email, String customerType) {
        return null;
    }


    @Override
    public Page<Facility> searchByNameOrFacilityType(Pageable pageable, String name, String facilityType) {
        return facilityRepository.searchByNameOrFacilityType(pageable, name, facilityType);
    }
}
