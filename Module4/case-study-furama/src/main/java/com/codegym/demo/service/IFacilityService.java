package com.codegym.demo.service;

import com.codegym.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService extends IGeneralService<Facility> {
    Page<Facility> searchByNameOrFacilityType(Pageable pageable, String name, String facilityType);
}
