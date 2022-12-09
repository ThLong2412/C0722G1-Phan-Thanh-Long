package com.codegym.demo.service.impl.contract;

import com.codegym.demo.model.contract.AttachFacility;
import com.codegym.demo.repository.contract.IAttachFacilityRepository;
import com.codegym.demo.service.inter.contract.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {

    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return attachFacilityRepository.findAll();
    }

}
