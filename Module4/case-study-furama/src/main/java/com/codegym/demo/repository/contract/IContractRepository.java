package com.codegym.demo.repository.contract;

import com.codegym.demo.model.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract, Long> {
}
