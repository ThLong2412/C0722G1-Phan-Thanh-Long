package com.codegym.demo.service.inter.contract;

import com.codegym.demo.dto.ContractDto;
import com.codegym.demo.model.contract.Contract;
import com.codegym.demo.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService extends IGeneralService<Contract> {
    Page<ContractDto> findAllContractView(Pageable pageable);
}
