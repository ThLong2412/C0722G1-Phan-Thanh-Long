package com.codegym.demo.service.inter.contract;

import com.codegym.demo.model.contract.AttachFacility;
import com.codegym.demo.model.contract.ContractDetail;
import com.codegym.demo.service.IExtraService;

public interface IContractDetailService extends IExtraService<ContractDetail> {
    void save(ContractDetail contractDetail);
}
