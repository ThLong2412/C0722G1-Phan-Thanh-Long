package service.impl;

import model.CustomerType;
import repositoy.ICustomerTypeRepository;
import repositoy.impl.CustomerTypeRepository;
import service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();
    @Override
    public List<CustomerType> listCustomerType() {
        return customerTypeRepository.listCustomerType();
    }
}
