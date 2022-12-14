package com.codegym.demo.service.impl.contract;

import com.codegym.demo.dto.ContractDto;
import com.codegym.demo.model.contract.Contract;
import com.codegym.demo.repository.contract.IContractDetailRepository;
import com.codegym.demo.repository.contract.IContractRepository;
import com.codegym.demo.service.inter.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> findByTd(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> search(Pageable pageable, String name, String email, String customerType) {
        return null;
    }

    @Override
    public Page<ContractDto> findAllContractView(Pageable pageable) {
        return contractRepository.findAllContractView(pageable);
    }
}
