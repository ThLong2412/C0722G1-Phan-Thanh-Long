package com.codegym.demo.repository.facility;

import com.codegym.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Long> {
    @Query(value = "select * from facility as f where  (f.name like concat('%',:name,'%') and f.facility_type_id like concat ('%',:facilityTypeId,'%') )"
            , countQuery = "select * from facility as f where  (f.name like concat('%',:name,'%') and f.facility_type_id like concat ('%',:facilityTypeId,'%') )"
            , nativeQuery = true)
    Page<Facility> searchByNameOrFacilityType(Pageable pageable, @Param("name") String name, @Param("facilityTypeId") String facilityTypeId);
}
