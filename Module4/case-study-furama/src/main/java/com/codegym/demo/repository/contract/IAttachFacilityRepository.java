package com.codegym.demo.repository.contract;

import com.codegym.demo.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Long> {
}
