package com.codegym.demo.repository.contract;

import com.codegym.demo.dto.ContractDto;
import com.codegym.demo.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
    @Query(value = "SELECT c.id, c.date_start as startDate, c.date_end as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue,employee.employee_name as employeeName FROM contract c left join employee on c.employee_id = employee.employee_id LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            ,countQuery="SELECT c.id, c.date_start as startDate, c.date_end as endDate, c.deposit, cus.name as nameCustomer,f.name as nameFacility, (sum(ifnull(cd.quantity, 0) * ifnull(af.cost, 0)) + f.cost) AS totalValue,employee.employee_name as employeeName FROM contract c left join employee on c.employee_id = employee.employee_id LEFT JOIN contract_detail cd ON c.id = cd.contract_id LEFT JOIN attach_facility af ON cd.attach_facility_id = af.id LEFT JOIN facility f ON c.facility_id = f.id join customer as cus on c.customer_id = cus.id GROUP BY c.id ORDER BY c.id"
            , nativeQuery = true)
    Page<ContractDto> findAllContractView(Pageable pageable);
}
