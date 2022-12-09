package com.codegym.demo.service.impl.facility;

import com.codegym.demo.model.facility.RentType;
import com.codegym.demo.repository.facility.IRentTypeRepository;
import com.codegym.demo.service.inter.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService  implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
