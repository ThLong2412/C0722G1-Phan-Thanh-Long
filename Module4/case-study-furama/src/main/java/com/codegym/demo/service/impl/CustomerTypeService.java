package com.codegym.demo.service.impl;

import com.codegym.demo.model.CustomerType;
import com.codegym.demo.repository.ICustomerRepository;
import com.codegym.demo.repository.ICustomerTypeRepository;
import com.codegym.demo.service.ICustomerTypeService;
import com.codegym.demo.service.IExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public Page<CustomerType> findAll(Pageable pageable) {
        return customerTypeRepository.findAll(pageable);
    }
}
