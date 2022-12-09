package com.codegym.demo.service.impl.customer;

import com.codegym.demo.model.customer.CustomerType;
import com.codegym.demo.repository.customer.ICustomerTypeRepository;
import com.codegym.demo.service.inter.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
