package com.codegym.demo.service.impl.contract;

import com.codegym.demo.model.contract.AttachFacility;
import com.codegym.demo.model.contract.ContractDetail;
import com.codegym.demo.repository.contract.IContractDetailRepository;
import com.codegym.demo.service.inter.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        contractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return contractDetailRepository.findAll();
    }
}
