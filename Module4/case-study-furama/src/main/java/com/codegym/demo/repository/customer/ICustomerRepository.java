package com.codegym.demo.repository.customer;

import com.codegym.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * from customer as c where  (c.name like concat('%',:name,'%') and c.email like concat('%',:email,'%') and c.customer_type_id like concat ('%',:customerTypeId,'%') )"
            , countQuery = "select * from customer as c where  (c.name like concat('%',:name,'%') and c.email like concat('%',:email,'%') and c.customer_type_id like concat ('%',:customerTypeId,'%') )"
            , nativeQuery = true)
    Page<Customer> search( Pageable pageable,@Param("name") String name, @Param("email") String email, @Param("customerTypeId") String customerTypeId);
}
