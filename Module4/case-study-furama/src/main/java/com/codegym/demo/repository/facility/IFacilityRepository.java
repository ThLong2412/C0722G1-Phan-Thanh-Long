package com.codegym.demo.repository.facility;

import com.codegym.demo.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IFacilityRepository extends JpaRepository<Facility, Long> {
    @Query(value = "select * from facility as f where (f.flag_delete = false ) and (f.name like concat('%',:name,'%') and f.facility_type_id like concat ('%',:facilityTypeId,'%') )"
            , countQuery = "select * from facility as f where (f.flag_delete = false ) and  (f.name like concat('%',:name,'%') and f.facility_type_id like concat ('%',:facilityTypeId,'%') )"
            , nativeQuery = true)
    Page<Facility> searchByNameOrFacilityType(Pageable pageable, @Param("name") String name, @Param("facilityTypeId") String facilityTypeId);

    @Transactional
    @Modifying
    @Query(value = "update facility f set f.flag_delete = true where f.id = :id", nativeQuery = true)
    void removeFlag(@Param("id") Long id);
}
