package com.codegym.demo.repository.customer;

import com.codegym.demo.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Long> {
}
