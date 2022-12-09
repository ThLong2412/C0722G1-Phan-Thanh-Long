package com.codegym.demo.repository.contract;

import com.codegym.demo.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail, Long> {
}
