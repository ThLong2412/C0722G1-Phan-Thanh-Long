package com.codegym.demo.service.impl.facility;

import com.codegym.demo.model.facility.FacilityType;
import com.codegym.demo.repository.facility.IFacilityTypeRepository;
import com.codegym.demo.service.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FacilityTypeService implements IFacilityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return facilityTypeRepository.findAll();
    }
}
