package com.codegym.demo.repository.facility;

import com.codegym.demo.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Long> {
}
