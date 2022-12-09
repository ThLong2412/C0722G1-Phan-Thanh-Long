package com.codegym.demo.service.inter.facility;

import com.codegym.demo.model.facility.Facility;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService extends IGeneralService<Facility> {
    Page<Facility> searchByNameOrFacilityType(Pageable pageable, String name, String facilityType);
}
