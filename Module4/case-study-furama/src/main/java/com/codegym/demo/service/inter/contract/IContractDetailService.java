package com.codegym.demo.service.inter.contract;

import com.codegym.demo.dto.IContractDetailDto;
import com.codegym.demo.model.contract.AttachFacility;
import com.codegym.demo.model.contract.ContractDetail;
import com.codegym.demo.service.IExtraService;

import java.util.List;

public interface IContractDetailService extends IExtraService<ContractDetail> {
    void save(ContractDetail contractDetail);
    List<IContractDetailDto> showAll(Long id);
}
