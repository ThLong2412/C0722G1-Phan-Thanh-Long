package com.codegym.demo.repository.contract;

import com.codegym.demo.dto.IContractDetailDto;
import com.codegym.demo.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {
    @Query(value = "select attach_facility.name as nameDto, " +
            "attach_facility.init as unitDto, sum(ifnull(contract_detail.quantity, 0)) as quantityDto, " +
            "attach_facility.cost as costDto " +
            "from contract_detail join attach_facility " +
            "on contract_detail.attach_facility_id = attach_facility.id " +
            "where contract_detail.contract_id = :idFind group by attach_facility.id;", nativeQuery = true)
    List<IContractDetailDto> showAll(@Param("idFind") Long id);
}
