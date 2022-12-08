package com.codegym.demo.repository.facility;

import com.codegym.demo.model.facility.RentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface IRentTypeRepository extends JpaRepository<RentType, Long> {
}
