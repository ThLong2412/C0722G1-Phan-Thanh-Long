package com.codegym.demo.repository.employee;

import com.codegym.demo.model.customer.Customer;
import com.codegym.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {


    @Query(value = "select * from employee as e where (e.flag_delete = false) and (e.employee_name like concat('%',:name,'%'))"
            , countQuery = "select * from employee as e where (e.flag_delete = false) and (e.employee_name like concat('%',:name,'%'))"
            , nativeQuery = true)
    Page<Employee> findEmployee(Pageable pageable, @Param("name") String name);


    @Transactional
    @Modifying
    @Query(value = "update employee e set e.flag_delete = true where e.employee_id = :id", nativeQuery = true)
    void removeFlag(@Param("id") Long id);
}
